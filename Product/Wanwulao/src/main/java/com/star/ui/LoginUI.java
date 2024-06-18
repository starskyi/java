package com.star.ui;

import com.star.dao.UserDao;
import com.star.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import static com.star.ui.MainInterface.jf;

public class LoginUI extends JDialog{

    JTextField  username;
    JPasswordField password;
    UserDao userDao = new UserDao();
    public LoginUI(){

        setSize(900,507);
        setLayout(null);



        setLocationRelativeTo(null);

        JLabel student=new JLabel("购物系统");
        student.setForeground(new Color(0xFF0000));

        student.setFont(new Font("宋体",Font.PLAIN,40));
        student.setBounds(280,50,800,100);
        add(student);

        JLabel demo_user=new JLabel("账号");
        demo_user.setForeground(new Color(0xFF4800));
        demo_user.setFont(new Font("楷体",Font.PLAIN,20));
        demo_user.setBounds(200,140,200,100);
        add(demo_user);

        username=new JTextField(20);
        username.setFont(new Font("宋体",Font.PLAIN,20));
        username.setSelectedTextColor(new Color(0xFF0000));
        username.setBounds(330,170,280,40);
        add(username);

        JLabel html_user=new JLabel("密码");
        html_user.setForeground(new Color(0xFF0000));
        html_user.setFont(new Font("楷体",Font.PLAIN,20));
        html_user.setBounds(200,200,200,100);
        html_user.setVisible(true);
        add(html_user);

        password=new JPasswordField(20);
        password.setFont(new Font(null, Font.BOLD, 20));
        password.setBounds(330,230,280,40);
        add(password);

        final JButton jbt=new JButton("登录");
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user = userDao.findUser(username.getText(), new String(password.getPassword()));
                if(user == null){
                    JOptionPane.showMessageDialog(jf, "登录失败");
                }else{
                    setVisible(false);
                    JOptionPane.showMessageDialog(jf, "登录成功");
                    MainInterface.user = user;
                    MainInterface.username.setText("用户： " + username.getText());
                    DecimalFormat df = new DecimalFormat("# 0.00");
                    MainInterface.money.setText("余额： " + df.format(user.getMoney()) + "");
                }
            }
        });
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if((int)e.getKeyChar() == 10) jbt.doClick();
            }
        };
        username.addKeyListener(keyAdapter);
        password.addKeyListener(keyAdapter);
        jbt.setForeground(new Color(0x023BF6));
        jbt.setBackground(new Color(0x38FF00));
        jbt.setFont(new Font("楷体",Font.PLAIN,20));
        jbt.setBorderPainted(true);
        jbt.setBounds(400,330,100,50);
        add(jbt);

        setVisible(true);
    }

}

