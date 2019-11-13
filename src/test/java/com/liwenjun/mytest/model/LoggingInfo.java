package com.liwenjun.mytest.model;

import java.io.Serializable;
import java.util.Date;

public class LoggingInfo implements Serializable {
    private Date loggingDate = new Date();

    private String uid;

    private transient String pwd;

    public LoggingInfo(String user, String password) {
        uid = user;
        pwd = password;
    }

    public Date getLoggingDate() {
        return loggingDate;
    }

    public void setLoggingDate(Date loggingDate) {
        this.loggingDate = loggingDate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString() {
        String password=null;
        if(pwd == null) {
            password = "NOT SET";
        }
        else {
            password = pwd;
        }
        return"logon info: \n   " + "user: " + uid +
                "\n   logging date : " + loggingDate.toString() +
                "\n   password: " + password;
    }
}
