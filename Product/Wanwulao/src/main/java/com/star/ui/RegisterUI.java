package com.star.ui;

import com.star.component.MyLabel;
import com.star.component.MyTextField;
import com.star.dao.UserDao;
import com.star.domain.User;
import com.star.utils.ScreenUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.star.ui.MainInterface.jf;

public class RegisterUI extends JDialog {
    JButton eBtn;


    int width = 1000;
    int height = 800;


    JTextField usernameF = new MyTextField(20);;
    JPasswordField passwordF = new JPasswordField(20);
    JTextField name = new MyTextField(20);
    JTextField phone = new MyTextField(20);
    JTextField address = new MyTextField(20);
    JTextField sex = new MyTextField(20);

    JTextField[] fields = {usernameF, passwordF, name, phone, address, sex};


    UserDao userDao = new UserDao();

    public RegisterUI(){


        Box uBox = Box.createHorizontalBox();
        uBox.setPreferredSize(new Dimension(400, 40));
        JLabel uLabel = new MyLabel("账号：");
        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(30));
        uBox.add(usernameF);

        Box pBox = Box.createHorizontalBox();
        pBox.setPreferredSize(new Dimension(400, 40));
        JLabel pLabel = new MyLabel("密码：");
        passwordF.setFont(new Font(null, Font.BOLD, 20));
        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(30));
        pBox.add(passwordF);

        Box nBox = Box.createHorizontalBox();
        JLabel nLabel = new MyLabel("姓名：");
        nBox.add(nLabel);
        nBox.add(Box.createHorizontalStrut(30));
        nBox.add(name);

        Box sexBox = Box.createHorizontalBox();
        JLabel sexL = new MyLabel("性别：");
        sexBox.add(sexL);
        sexBox.add(Box.createHorizontalStrut(30));
        sexBox.add(sex);

        Box phoneBox = Box.createHorizontalBox();
        JLabel phoneL = new MyLabel("电话：");
        phoneBox.add(phoneL);
        phoneBox.add(Box.createHorizontalStrut(30));
        phoneBox.add(phone);

        Box addressBox = Box.createHorizontalBox();
        JLabel addressL = new MyLabel("地址：");
        addressBox.add(addressL);
        addressBox.add(Box.createHorizontalStrut(30));
        addressBox.add(address);

        Box btnBox = Box.createHorizontalBox();
        btnBox.setPreferredSize(new Dimension(400, 50));
        final JButton register = new JButton("注册");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameF.getText();
                String password = new String(passwordF.getPassword());

                if(username == null || username.replace(" ", "").equals("")
                        || password == null || password.replace(" ", "").equals("")){
                    JOptionPane.showMessageDialog(jf, "用户名或密码不能为空");
                }else{
                    try{
                        userDao.add(new User(null, username, password,
                                name.getText(), phone.getText(), 0, sex.getText(),address.getText(), 0.0));
                        JOptionPane.showMessageDialog(jf, "注册成功");
                        setVisible(false);
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(jf, "注册失败");
                        e1.printStackTrace();
                    }

                }
            }
        });
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if((int)e.getKeyChar() == 10) register.doClick();
            }
        };

        for (JTextField field : fields) {
            field.addKeyListener(keyAdapter);
        }

        register.setFont(new Font(null, Font.BOLD, 30));
        btnBox.add(register);

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(nBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(sexBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(phoneBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(addressBox);
        vBox.add(Box.createVerticalStrut(60));
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
