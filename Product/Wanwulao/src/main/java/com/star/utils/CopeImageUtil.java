package com.star.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CopeImageUtil {
    public static BufferedImage cutHeadImages(String path){
        BufferedImage headImg = null;
        try {
            headImg = ImageIO.read(new File(path));
            //headImg = scaleByPercentage(headImg, headImg.getWidth(), headImg.getWidth());
            int width = headImg.getWidth();

            BufferedImage formatHeadImg = new BufferedImage(width, width, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = formatHeadImg.createGraphics();

            //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int border = 1;
            Ellipse2D.Double shape = new Ellipse2D.Double(border, border, width - 200 * border, width -  200 * border);
            g.setClip(shape);
            g.drawImage(headImg, border, border, width - border * 200, width - border * 200, null);
            g.dispose();

//            g = formatHeadImg.createGraphics();
//            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            int border2 = 20;
//
//            Stroke s = new BasicStroke(5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
//            g.setStroke(s);
//            g.setColor(Color.BLACK);
//            g.drawOval(border2, border2, width - border2 * 2, width - border2 * 2);
//            g.dispose();

            return formatHeadImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static BufferedImage scaleByPercentage(BufferedImage inputImg, int newWidth, int newHeight){
        try{
            int type = inputImg.getColorModel().getTransparency();
            int width = inputImg.getWidth();
            int height = inputImg.getHeight();

            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            BufferedImage img = new BufferedImage(newWidth, newHeight, type);
            Graphics2D g = img.createGraphics();
            g.setRenderingHints(renderingHints);
            g.drawImage(inputImg, 0, 0, newWidth, newHeight, 0, 0, width, height, null);
            g.dispose();
            return img;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }
    public static class MyPanel extends JPanel{
        BufferedImage img;

        public MyPanel(BufferedImage img){
            this.img = img;
            Dimension size = new Dimension(img.getWidth()/2, img.getWidth()/2);
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
            setOpaque(true);
            setBackground(Color.GREEN);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
        }
    }
    public static void main(String[] args){
        BufferedImage img = cutHeadImages("D:\\code\\java\\TDYJ2\\shop\\src\\main\\resources\\img\\logo.jpg");
        BufferedImage img2 = CircleImageUtil.getCircleImage("logo.jpg", 100);
        JFrame jf = new JFrame();
        jf.setLayout(null);


        jf.add(new MyPanel(img2));
        jf.pack();
        jf.setBounds(500, 500, 800, 600);
        jf.setVisible(true);



    }

}
