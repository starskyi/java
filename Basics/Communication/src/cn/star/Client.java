package cn.star;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("===========客户端启动===========");
        System.out.println("==========输入 exit 退出========");
        //创建发送端
        DatagramSocket socket = new DatagramSocket();

        //设置目标ip地址
        //InetAddress address = InetAddress.getLocalHost();

        //广播地址
        InetAddress i = InetAddress.getByName("192.168.0.255");

        //不断写入并发送数据
        Scanner sc  = new Scanner(System.in);
        byte[] buf;
        while(true){
            System.out.print("请输入消息：");
            String message = sc.next();
            if(message.equals("exit")){
                System.out.println("离线成功!");
                socket.close();
                break;
            }
            buf = message.getBytes();

            //封装数据
            DatagramPacket packet = new DatagramPacket(buf,buf.length,i,888);

            //发送数据
            socket.send(packet);
        }


    }
}