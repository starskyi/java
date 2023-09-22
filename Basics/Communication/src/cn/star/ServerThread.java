package cn.star;

import java.io.*;
import java.net.Socket;

import static cn.star.ServiceDemo1.sockets;

public class ServerThread extends Thread{
    Socket socket;
    String ip;
    String name;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        ip = socket.getRemoteSocketAddress().toString();


        try {
            //获取接收流道
            InputStream is = socket.getInputStream();

            //封装流道
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //接收消息
            String msg;
            name = br.readLine();
            System.out.println(name + "上线了!");
            while((msg = br.readLine()) != null){
                System.out.println(ip + "  " + name + "说了：" + msg);

                //转发消息
                /*
                for(Socket socket : sockets.keySet()){
                    if(socket == this.socket){
                        continue;
                    }
                    new PrintStream(socket.getOutputStream()).println(msg);
                }

                 */


                for(Socket socket : sockets){
                    if(socket == this.socket){
                        continue;
                    }
                    new PrintStream(socket.getOutputStream()).println(name + "：" + msg);
                }

            }

        } catch (IOException e) {
            sockets.remove(socket);
            System.out.println(name + "下线了!");
        }
    }
}
