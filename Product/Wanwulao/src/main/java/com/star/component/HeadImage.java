package com.star.component;

import com.star.utils.CircleImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class HeadImage extends JPanel {
    BufferedImage image;
    Dimension size;
    JFrame jf;

    public HeadImage(String path, int radius, final JFrame jf){
        this.jf = jf;
        this.size = new Dimension(radius * 2, radius * 2);
        this.image = CircleImageUtil.getCircleImage(path, radius);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

    }


}
