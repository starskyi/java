package com.star.ui;

import com.star.dao.AdminDao;
import com.star.domain.Admin;
import com.star.utils.ScreenUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.star.ui.MainInterface.jf;

public class AdminLoginUI extends JDialog {
    JButton eBtn;


    int width = 600;
    int height = 400;


    JTextField username;
    JPasswordField password;
    AdminDao adminDao = new AdminDao();

    public AdminLoginUI(JButton eBtn1){
        this.eBtn = eBtn1;

        Box uBox = Box.createHorizontalBox();
        uBox.setPreferredSize(new Dimension(400, 40));
        JLabel uLabel = new JLabel("账号：");
        username = new JTextField(15);
        uLabel.setFont(new Font(null, Font.BOLD, 20));
        username.setFont(new Font(null, Font.BOLD, 20));
        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(30));
        uBox.add(username);

        Box pBox = Box.createHorizontalBox();
        pBox.setPreferredSize(new Dimension(400, 40));
        JLabel pLabel = new JLabel("密码：");
        password = new JPasswordField(15);
        pLabel.setFont(new Font(null, Font.BOLD, 20));
        password.setFont(new Font(null, Font.BOLD, 20));
        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(30));
        pBox.add(password);


        Box btnBox = Box.createHorizontalBox();
        btnBox.setPreferredSize(new Dimension(400, 50));
        JButton login = new JButton("登录");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adminDao.selectAdmin(new Admin(null, username.getText(),
                        new String(password.getPassword()))) != null){
                    //管理员登录成功
                    setVisible(false);
                    if(eBtn.getText().equals("用户管理")) {
                        new UserManagerUI();
                    }else{
                        new CommodityManagerUI();
                    }

                }else{
                    //管理员登录失败
                    JOptionPane.showMessageDialog(jf, "该账号权限不够，请联系江哥给你个管理员账号");
                }
            }
        });
        JButton cancel = new JButton("取消");
        login.setFont(new Font(null, Font.BOLD, 20));
        cancel.setFont(new Font(null, Font.BOLD, 20));
        btnBox.add(login);
        btnBox.add(Box.createHorizontalStrut(80));
        btnBox.add(cancel);

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(btnBox);

        JPanel p = new JPanel();
        p.setBounds(0, 0 , width, height);
        p.add(vBox);
        add(p);

        setResizable(false);
        setBounds((ScreenUtil.getScreenWidth() - 500)/2, (ScreenUtil.getScreenHeight() - height)/2, width, height);
        setVisible(true);
    }
}
