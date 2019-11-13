package com.liwenjun.mytest.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static int a = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{

        testCountDownLatch();

        int calcTimes = 30000*10;
        //开三个线程
        int threadCount = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++){
            new Thread(() -> {
                for(int j = 0; j < calcTimes; j++){
//                    calc();
                    atomicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.err.println(System.currentTimeMillis() - beginTime);
        System.err.print(a);

    }


    public synchronized static final void calc(){
        a = a+1;
    }


    public static void testCountDownLatch(){

        int threadCount = 10;

        final CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i=0; i< threadCount; i++){

            new Thread(new Runnable() {

                @Override
                public void run() {

                    System.out.println("线程" + Thread.currentThread().getId() + "开始出发");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");

                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("10个线程已经执行完毕！开始计算排名");
    }

}
