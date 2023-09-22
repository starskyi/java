package com.star.component;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {

    public MyTextField(int columns){
        super(columns);

        setFont(new Font(null, Font.BOLD, 30));

    }

    public MyTextField(String text, int columns){
        super(text, columns);

        setFont(new Font(null, Font.BOLD, 30));
    }
}
