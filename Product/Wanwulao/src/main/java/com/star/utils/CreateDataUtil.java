package com.star.utils;

import com.star.domain.Commodity;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CreateDataUtil {

    public static void createData(Vector<Vector> data, List<Commodity> goods){
        int i = 1;
        for(Commodity commodity : goods){
            Vector vector = new Vector();
            List<String> list = Arrays.asList(i + "", commodity.getImage(), commodity.getTitle(), commodity.getShop(),
                    commodity.getPrice() + "", commodity.getRepertory() + "");
            vector.addAll(list);
            data.add(vector);
            i++;
        }
    }
}
