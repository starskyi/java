package cn.star;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
    Socket socket;

    public ReceiveThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        //
        try{
            //获取传输流道
            InputStream is = socket.getInputStream();

            //封装流道
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //打印消息
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }

        }catch(Exception e){

        }
    }
}
