package cn.star.demo;


public class Demo1 {
    public static void main(String[] args){
        float f = 234.34f;
        int num = 235;
        new Demo2().run();
        new Demo1().new Demo3().eat();
    }
static class Demo2{
        int a;
        int b;
        void run(){
            System.out.println("hello");
        }
}
class Demo3{
        void eat(){
            System.out.println("eat");
        }
}


}
