package com.star.component;

import javax.swing.*;
import java.awt.*;

public class BestBox extends Box {
    private Dimension size;

    public BestBox(int axis, int width, int height){
        super(axis);
        this.size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
}
