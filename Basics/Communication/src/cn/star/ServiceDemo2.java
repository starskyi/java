package cn.star;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServiceDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("============服务端启动===========");

        //创建服务端
        ServerSocket serverSocket = new ServerSocket(999);

        //创建线程池
        ExecutorService poolExecutor = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //等待连接
        while(true){
            Socket socket = serverSocket.accept();

            //创建任务，执行任务
            ServiceRunnable task = new ServiceRunnable(socket);

            poolExecutor.execute(task);

        }
    }
}
