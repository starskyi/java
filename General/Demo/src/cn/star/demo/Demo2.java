package cn.star.demo;

import java.util.Date;
import java.util.Scanner;

public class Demo2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        //int[] arr = createArr();
        int[] arr = createArr2();
        //printArr(arr);
        sortArr(arr);
        //printArr(arr);
        int[] arr2;

        while(true){
            System.out.print("请输入一个数:");
            int num = sc.nextInt();

            long start1 = new Date().getTime();
            arr2 = insert(arr, num);
            long end1 = new Date().getTime();
            //printArr(arr2);

            long start2 = new Date().getTime();
            arr2 = insert2(arr, num);
            long end2 = new Date().getTime();
            //printArr(arr2);
            System.out.println((end1 - start1) + "  " + (end2 - start2));

        }


    }

    public static int[] insert2(int[] arr, int num){
        int len = arr.length;
        int index = -1;
        int[] arr2 = new int[len + 1];
        for(int i = 0; i < len; i++){
            arr2[i] = arr[i];
        }

        for(int i = 0; i < len; i++){
            if(num < arr[i]){
                index = i;
                break;
            }
        }
        if(index == -1){
            arr2[len] = num;
        }else{
            for(int i = index + 1; i < len + 1; i++){
                arr2[i] = arr[i - 1];
            }
            arr2[index] = num;
        }
        return arr2;
    }

    public static int[] insert(int[] arr, int num){
        int len = arr.length;
        int[] arr2 = new int[len + 1];

        int start = 0, end = len - 1, now = 0;
        while (start <= end) {
            now = (start + end)/2;
            if(num > arr[now]){
                start = now + 1;
            }else{
                end = now - 1;
            }
        }
        for(int i = 0; i < start; i++){
            arr2[i] = arr[i];
        }
        arr2[start] = num;
        for(int i = start + 1; i <= len; i++){
            arr2[i] = arr[i - 1];
        }
        return arr2;
    }

    public static void sortArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int tmp;
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static int[] createArr2(){
        System.out.print("请输入数组大小:");

        int len = sc.nextInt();
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = i*2;
        }

        return arr;
    }

    public static int[] createArr(){
        System.out.print("请输入数组大小:");
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            System.out.print("请输入第" + (i + 1) + "个数:");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for (int j : arr) {
            System.out.print(j + "  ");
        }
        System.out.println();
    }
}
