package com.liwenjun.mytest.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        Callable<Integer> calculateCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                int result = 1+2;
                return result;
            }
        };

        FutureTask<Integer> calculateFutureTask = new FutureTask<>(calculateCallable);
        Thread t1 = new Thread(calculateFutureTask);
        t1.start();

        try {


            Thread.sleep(3000);
            int a = 3 + 5;
            Integer result = calculateFutureTask.get();
            System.out.println("result="+(a+result));
            long endTime = System.currentTimeMillis();
            System.out.println("time="+(endTime-startTime));
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

}
