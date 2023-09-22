package cn.star;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception{
        System.out.println("============客户端启动=============");

        //创建发送端
        Socket socket = new Socket(InetAddress.getLocalHost(),666);

        //开启多线程接收消息
        new ReceiveThread(socket).start();

        //获取输出流
        OutputStream os = socket.getOutputStream();

        //封装流道
        PrintStream ps = new PrintStream(os);

        //备注姓名
        Scanner sc = new Scanner(System.in);
        System.out.println("请备注你的姓名：");
        String name = sc.next();
        ps.println(name);
        System.out.println("welcome " + name + " !" + "开始聊天：");

        //发送信息
        while(true){
            ps.println(sc.next());
        }

    }
}
