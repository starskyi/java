package com.star.utils;

import java.lang.reflect.Field;
import java.util.List;

public class JsonUtil {
    public static String listToJson(List<Object> list) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("[");
        for(Object object : list){
            Field[] fields = object.getClass().getDeclaredFields();
            json.append("{");
            for(Field field : fields){
                field.setAccessible(true);
                if(field.getType() == int.class || field.getType() == Integer.class){
                    json.append("\"" + field.getName() + "\":" + field.get(object));
                }else{
                    json.append("\"" + field.getName() + "\":\"" + field.get(object) + "\"");
                }
                json.append(",");
            }
            json.replace(0, json.length(), json.substring(0, json.length() - 1));
            json.append("},");
        }
        json.replace(0, json.length(), json.substring(0, json.length() - 1));
        json.append("]");
        return json.toString();
    }
}
