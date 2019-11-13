package com.liwenjun.mytest.thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TestThread {


    public static void main(String[] args) throws Exception{

        Runnable task = () ->{
            System.out.println("Hello World !");
        };

        Thread myThread = new Thread(task);
        myThread.start();
        System.out.println("################");
        myThread.join();


    }




}
