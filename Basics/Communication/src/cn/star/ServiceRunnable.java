package cn.star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServiceRunnable implements Runnable{
    Socket socket;
    String ip;

    public ServiceRunnable(Socket socket){
        this.socket = socket;
    }


    public void run(){
        ip = socket.getRemoteSocketAddress().toString();
        System.out.println(ip + "上线了!");

        //获取流道接收消息
        try {
            InputStream is = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(ip + "说了：" + msg);
            }
        } catch (IOException e) {
            System.out.println(ip + "下线了!");
        }
    }
}
