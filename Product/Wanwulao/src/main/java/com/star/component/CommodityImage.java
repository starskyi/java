package com.star.component;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CommodityImage extends JPanel {
    BufferedImage image;
    Dimension size;

    public CommodityImage(BufferedImage image){
        this.image = image;
        BufferedImage bestImg = new BufferedImage(300, 300, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = bestImg.createGraphics();
        g.drawImage(image, 0, 0, 300, 300, null);
        g.dispose();

        this.image = bestImg;
        size = new Dimension(300, 300);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);

    }
}
