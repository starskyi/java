package cn.star;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Service {
    public static void main(String[] args) throws Exception{
        System.out.println("==========服务端启动==========");
        //创建接收端
        DatagramSocket socket = new DatagramSocket(888);

        //设置接收数据的桶
        byte[] buf = new byte[1024];

        //封装接收数据
        DatagramPacket packet = new DatagramPacket(buf,0,buf.length);

        //不断接收
        while(true){
            socket.receive(packet);
            System.out.println("收到来自 "  + packet.getAddress() + " 的消息：" + new String(buf,0,packet.getLength()));

        }

    }
}

