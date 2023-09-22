package com.star.component;

import javax.swing.*;
import java.awt.*;

public class BestButton extends JButton {

    private Dimension size;

    public BestButton(String text, String name){
        super(text);
        super.setName(name);
        setFont(new Font(null, Font.BOLD, 20));
        setLayout(null);
    }
}
