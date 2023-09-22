package com.star.ui;

import com.star.component.PayImage;
import com.star.dao.CommodityDao;
import com.star.dao.UserDao;
import com.star.domain.Record;
import com.star.utils.ScreenUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.star.ui.MainInterface.*;

public class PayUI extends JDialog {

    Record record;
    UserDao userDao = new UserDao();
    CommodityDao commodityDao = new CommodityDao();
    public PayUI(Record record1){
        this.record = record1;

        setLocation((ScreenUtil.getScreenWidth() - 800)/2, (ScreenUtil.getScreenHeight() - 1200)/2);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 1200));
        JLabel title = new JLabel("请扫码支付或使用余额支付");
        title.setFont(new Font(null, Font.BOLD, 40));

        panel.add(title);
        panel.add(new PayImage());

        JButton btn = new JButton("余额支付");
        btn.setFont(new Font(null, Font.BOLD, 30));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.getMoney() >= record.getPrice()){
                    //支付成功
                    setVisible(false);
                    userDao.buy(record);

                    JOptionPane.showMessageDialog(jf, "支付成功");
                    user = new UserDao().selectById(user.getId());
                    username.setText("用户：" + user.getName());
                    money.setText("余额：" + user.getMoney());

                }else{
                    //支付失败
                    JOptionPane.showMessageDialog(jf, "余额不足，请扫描支付");
                }
            }
        });
        System.out.println("aaa");
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(700, 30));
        panel.add(p);
        panel.add(btn);
        add(panel);
        pack();
        setVisible(true);
    }
}
