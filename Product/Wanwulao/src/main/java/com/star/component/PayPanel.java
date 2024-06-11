package com.star.component;

import javax.swing.*;
import java.awt.*;

public class PayPanel extends JPanel {
    public PayPanel(){
        setPreferredSize(new Dimension(550, 720));
        JLabel title = new JLabel("请扫码支付或使用余额支付");
        title.setFont(new Font(null, Font.BOLD, 40));

        add(title);
        add(new PayImage());
        add(new JButton("余额支付"));
    }
}
