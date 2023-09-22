package cn.star.demo;

import java.util.Random;

public class ThreeDoor {
    public static double size = 1000;
    public static boolean change = true;
    public static void main(String[] args){
        int target, select, count = 0, otherDoor;
        Random rd = new Random();
        int i = 0;
        while(i < size){
            target = rd.nextInt(3) + 1;
            select = rd.nextInt(3) + 1;
            if(select == target){
                count += 1;
            }
            i++;
        }
        System.out.println(count/size);



        if(change){
            count = 0;
            i = 0;
            while(i < size){
                target = rd.nextInt(3) + 1;
                select = rd.nextInt(3) + 1;

                if(target != select){
                    count += 1;
                }
                i++;
            }
            System.out.println(count/size);
        }
    }
}
