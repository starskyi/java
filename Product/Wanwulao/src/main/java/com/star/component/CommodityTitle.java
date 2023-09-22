package com.star.component;

import javax.swing.*;
import java.awt.*;

public class CommodityTitle extends JLabel {

    Dimension size = new Dimension(380, 80);

    public CommodityTitle(String text){
        setFont(new Font(null, Font.BOLD, 20));
        setAlignmentX(10);
        setText("<html>" + text + "</html>");
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
}
