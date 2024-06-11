package com.star.component;

import javax.swing.*;
import java.awt.*;

public class CommodityTitle extends JLabel {

    Dimension size = new Dimension(200, 80);

    public CommodityTitle(String text){
        setFont(new Font(null, Font.BOLD, 15));
        setAlignmentX(10);
        setText("<html>" + text + "</html>");
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
}
