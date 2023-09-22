package com.star.utils;

import com.star.ui.MainInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageIoUtil {
    public static BufferedImage read(String filename){
        BufferedImage image = null;
        try{
            image = ImageIO.read((MainInterface.class.getClassLoader().getResourceAsStream(filename)));
        } catch (Exception e) {
            try {
                image = ImageIO.read(new File(filename));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


        return image;
    }
}
