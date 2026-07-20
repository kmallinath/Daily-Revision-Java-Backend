package com.learn.springbootbasics.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarInterfaceInvocationHandler implements InvocationHandler {

    private Object target;

    public CarInterfaceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("I WILL BE CALLED BEFORE EACH CAR INTERFACE METHOD");
        Object ans=method.invoke(target,args);
        System.out.println(ans);
        System.out.println("I WILL BE CALLED AFTER EACH CAR INTERFACE METHOD");
        return ans;
    }
}
