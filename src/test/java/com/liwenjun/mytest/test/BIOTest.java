package com.liwenjun.mytest.test;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTest {


    private static boolean isRun = true;

    public boolean isRun(){
        return isRun;

    }
    public static void setRun(boolean isRun) {
        isRun = isRun;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        //绑定端口
        serverSocket.bind(new InetSocketAddress("127.0.0.1",6666));
        //响应客户端的请求  阻塞
        while(isRun){
            Socket socket = serverSocket.accept();
            System.out.print("sss");
//            new Thread(new BioServerTask(socket)).start();
        }
    }


}
