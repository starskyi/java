package cn.star;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceDemo1 {

    static ArrayList<Socket> sockets = new ArrayList<>();
    //static Map<Socket,String> sockets = new HashMap<>();

    public static void main(String[] args) throws Exception{
        System.out.println("============服务端启动===========");

        //创建服务端
        ServerSocket serverSocket = new ServerSocket(666);

        //等待连接,接收消息
        while(true){
            Socket socket = serverSocket.accept();
            sockets.add(socket);
            new ServerThread(socket).start();
        }

    }
}
