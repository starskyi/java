package cn.star.reflect;

import java.lang.reflect.Field;

public class reflectDemo1 {
    public static void main(String[] args) throws IllegalAccessException {
        User user1 = new User();
        Class user = user1.getClass();

        Field[] fields = user.getDeclaredFields();
        System.out.println(fields[0].getType() == int.class);
        System.out.println(fields[0].getType() == Integer.class);
        for(Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName() + "===>" + field.getType() + ":" + field.get(user1));
        }
    }
}
