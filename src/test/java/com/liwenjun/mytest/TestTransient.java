package com.liwenjun.mytest;

import com.liwenjun.mytest.model.LoggingInfo;

import java.io.*;

public class TestTransient implements Serializable {


    public static void main(String[] args){
        LoggingInfo logInfo = new LoggingInfo("MIKE","dsffsd");
        System.out.println(logInfo.toString());

        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        } catch(Exception e) {
            //deal with exception
        }
        //To read the object back, we can write
        try {
            ObjectInputStream in =new ObjectInputStream(
                    new FileInputStream("logInfo.out"));
            LoggingInfo logInfoIn = (LoggingInfo)in.readObject();
            System.out.println(logInfoIn.toString());
        } catch(Exception e) {
            //deal with exception
        }
    }
}
