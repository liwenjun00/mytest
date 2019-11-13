package com.liwenjun.mytest;

import org.junit.Test;

public class TestSort {


    int[] a = {12,20,5,16,15,1,30,45,23,9};


    @Test
    public  void quickSort(){
        System.out.println("sort start...");
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        int start = 0;
        int end = a.length-1;
        int key = a[0];

        while(end > start){
            //从后向前比较
            while(end > start && a[end] >= key){
                end--;
                if(a[end] <= key){
                    int temp = a[end];
                    a[end] = a[start];
                    a[start] = temp;
                }
            }

            //从前向后比较
            while(end > start && a[start] <= key){
                start++;
                if(a[start] >= key){
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                }
            }

        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
