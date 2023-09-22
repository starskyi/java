package com.star.component;

import com.star.utils.ScreenUtil;

import javax.swing.*;
import java.awt.*;

public class GoodsPanel extends JPanel {
    Dimension size = new Dimension(2000, 800);

    public GoodsPanel(){
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
}
