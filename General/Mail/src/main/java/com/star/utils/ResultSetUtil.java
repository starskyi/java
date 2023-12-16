package com.star.utils;

import com.star.domain.Mail;
import com.star.domain.User;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtil {

    public static List getList(ResultSet res, Class objClass) throws Exception {
        List list = new ArrayList<Object>();
        Field[] fields = objClass.getDeclaredFields();
        while(res.next()){
            Object obj = objClass.getDeclaredConstructor().newInstance();
            for(int i = 0; i < fields.length; i++){

                fields[i].setAccessible(true);
                fields[i].set(obj,  res.getObject(i+1));
            }
            list.add(obj);
        }
        return list;
    }

}
