package cn.star.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class reflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        System.out.println(list);
        Class c = List.class;
        Method method = c.getMethod("add", Object.class);
        method.invoke(list, "hello");
        System.out.println(list);
    }
}
