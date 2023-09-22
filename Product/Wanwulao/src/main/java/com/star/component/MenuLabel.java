package com.star.component;

import javax.swing.*;
import java.awt.*;

public class MenuLabel extends JLabel {
    public MenuLabel(String text){
        setText(text);
        setFont(new Font(null, Font.BOLD, 30));
        setMaximumSize(new Dimension(100, 100));
    }
}
