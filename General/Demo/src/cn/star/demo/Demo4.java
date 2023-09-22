package cn.star.demo;

import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args){
        int[] arr1 = {10,11,12,13,14,15,16};
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = arr1;
        arr2[0] = 111;

        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1 +"    " + arr2);
        sum(arr1);
        System.out.println(Arrays.toString(arr1));
    }
    public static void sum(int[] arr1){
        int[] arr2 = arr1;
        for(int i = 0; i < arr2.length; i++){
            arr2[i] += 1;
        }
    }
}
