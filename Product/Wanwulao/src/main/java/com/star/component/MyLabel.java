package com.star.component;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(String text){
        setText(text);
        setFont(new Font(null, Font.BOLD, 30));
    }
}
