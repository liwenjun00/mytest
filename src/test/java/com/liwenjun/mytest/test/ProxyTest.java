package com.liwenjun.mytest.test;

import com.liwenjun.mytest.test.proxy.UserManager;
import com.liwenjun.mytest.test.proxy.UserManagerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest implements InvocationHandler {

    private Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target,args);
        System.out.println("JDK动态代理，监听结束！");

        return result;
    }

    //定义获取代理对象的方法
    private Object getJDKProxy(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);

    }

    public static void main(String[] args){
        ProxyTest jdkProxy = new ProxyTest();
        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        user.addUser("admin","1234");
    }
}
