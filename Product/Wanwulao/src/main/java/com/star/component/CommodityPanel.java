package com.star.component;

import com.star.dao.RecordDao;
import com.star.domain.Commodity;
import com.star.domain.Record;
import com.star.ui.LoginUI;
import com.star.ui.MainInterface;
import com.star.ui.PayUI;
import com.star.utils.ImageIoUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static com.star.ui.MainInterface.user;

public class CommodityPanel extends JPanel {
    BufferedImage image;

    Dimension size = new Dimension(500, 300);

    RecordDao recordDao = new RecordDao();

    Commodity commodity;
    public CommodityPanel(Commodity commodity1){
        this.commodity = commodity1;
        try {
            this.image = ImageIoUtil.read(commodity.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        JPanel textPanel = new JPanel();

        Dimension s = new Dimension(390, 300);
        textPanel.setPreferredSize(s);
        textPanel.setMinimumSize(s);
        textPanel.setMaximumSize(s);
        textPanel.setSize(s);


        String count = commodity.getCount() + "";

        if(commodity.getCount() >= 10000){
            count = count.substring(0, count.length() - 4) + "万";
        }
        JLabel title = new CommodityTitle(commodity.getTitle());
        title.setPreferredSize(new Dimension(380, 140));

        textPanel.add(title);
        textPanel.add(new CommodityTitle("<font color='#ff0000'>" +
                commodity.getPrice() + "&yen;</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销量：" + count + "+"));

        JLabel shop = new CommodityTitle(commodity.getShop());
        shop.setPreferredSize(new Dimension(300, 80));

        JPanel payPanel = new JPanel();

        final JButton payBtn = new JButton("购买");
        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user != null){
                    Record record = new Record(null, user.getId(), commodity.getId(), 1, commodity.getPrice());
                    recordDao.add(record);
                    new PayUI(record, payBtn);
                }else{
                    new LoginUI();
                }

            }
        });

        payPanel.add(shop);
        payPanel.add(payBtn);

        textPanel.add(payPanel);

        textPanel.setLocation(105, 0);
        JPanel imagePamel = new CommodityImage(image);
        imagePamel.setLocation(0, 10);
        add(imagePamel);
        add(textPanel);
        setOpaque(true);
        setBackground(new Color(75, 207, 250));

    }
}
