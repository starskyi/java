package com.star.component;

import com.star.dao.CommodityDao;
import com.star.dao.RecordDao;
import com.star.domain.Commodity;
import com.star.domain.Record;
import com.star.domain.User;
import com.star.ui.PayUI;
import com.star.utils.ImageIoUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class BuyPanel extends Box {
    Dimension size = new Dimension(1200, 300);

    Commodity commodity;
    User user;

    RecordDao recordDao = new RecordDao();
    Record record;

    BufferedImage bufferedImage;

    JButton statusBtn = new JButton();

    JLabel payStatus;

    Box vBox;
    public BuyPanel(final Record record, User user){
        super(BoxLayout.X_AXIS);
        setPreferredSize(size);

        commodity = new CommodityDao().selectById(record.getCid());
        this.user = user;
        this.record = record;
        try {
            bufferedImage = ImageIoUtil.read(commodity.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        CommodityImage image = new CommodityImage(bufferedImage);
        JLabel title = new CommodityTitle(commodity.getTitle());
        JLabel address = new CommodityTitle("收货地址：</br>" + user.getAddress());
        vBox = Box.createVerticalBox();
        JLabel price = new CommodityTitle("<font color=red>总价: " + commodity.getPrice() + "</font>");
        price.setPreferredSize(new Dimension(100, 50));

        payStatus = new CommodityTitle("");
        payStatus.setPreferredSize(new Dimension(100, 50));

        vBox.add(price);
        vBox.add(payStatus);
        statusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cmd = e.getActionCommand();
                if(cmd.equals("立即支付")){
                    new PayUI(record, statusBtn);
                }else{
                    record.setStatus(3);
                    recordDao.updateStatus(record);
                }
                judge();
            }
        });
        statusBtn.setFont(new Font(null, Font.BOLD, 15));
        vBox.add(statusBtn);
        judge();

        add(image);
        add(Box.createHorizontalStrut(10));
        add(title);
        add(Box.createHorizontalStrut(10));
        add(address);
        add(Box.createHorizontalStrut(10));
        add(vBox);
        setOpaque(true);
        setBackground(new Color(75, 207, 250));

    }



    public void judge(){
        int status = record.getStatus();
        switch(status){
            case 1:
                //未支付
                payStatus.setText("未支付");
                statusBtn.setText("立即支付");
                break;
            case 2:
                //已支付，待收货
                payStatus.setText("待收货");
                statusBtn.setText("确认收货");
                break;
            case 3:
                //已收货
                vBox.remove(statusBtn);
                payStatus.setText("已收货");
                break;
            default:
                break;
        }
        vBox.updateUI();
    }

}
