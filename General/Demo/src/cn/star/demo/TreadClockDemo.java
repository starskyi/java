package cn.star.demo;


public class TreadClockDemo {

    static int count = 0;
    static boolean[] flag = new boolean[2];
    static int turn = 0;
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 20; i++){
            count = 0;
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    for(int i = 0; i < 10000; i++){
                        flag[0] = true;
                        turn = 1;
                        while(flag[1] && turn == 1);
                        count++;
                        flag[0] = false;
                    }
                }
            };
            thread1.start();
            Thread2();
            thread1.join();
            System.out.println(count);
        }

    }

    public static void Thread2(){
        for(int i = 0; i < 10000; i++){
            flag[1] = true;
            turn = 0;
            while(flag[0] && turn == 0);
            count++;
            flag[1] = false;
        }
    }

}
