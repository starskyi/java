package com.star.utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CircleImageUtil {
    public static BufferedImage getCircleImage(String path, int radius){
        try {
            //加载源图像
            BufferedImage sImg = ImageIoUtil.read(path);

            //获取图像宽度
            int width = sImg.getWidth();

            //设置边框大小
            int border = 4;

            //创建新图像
            BufferedImage circleImage = new BufferedImage(width, width, BufferedImage.TYPE_4BYTE_ABGR);

            //获取画笔
            Graphics2D g = circleImage.createGraphics();

            //设置抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //获取圆形图形
            Ellipse2D.Double shape = new Ellipse2D.Double(3, 3, radius * 2, radius * 2);

            g.setClip(shape);
            //开始画图片
            g.drawImage(sImg, border, border,  radius * 2 - border, radius * 2 -border, null);

            //销毁画笔
            g.dispose();


            //从新获取画笔, 设置相关属性
            g = circleImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //设置绘制路劲相关属性
            Stroke s = new BasicStroke(5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            g.setStroke(s);
            g.setColor(Color.BLACK);

            //画边框
            g.drawOval(border * 2, border * 2, radius * 2 - 3 * border + 1, radius * 2 - border * 3 + 1);
            g.dispose();

            return circleImage;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
