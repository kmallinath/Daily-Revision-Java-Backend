package com.learn.day4aop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPClass {

    @Before("execution(* com.learn.day4aop.service.UserActionImpl.userLogin(..))")
    public void beforeMethodofUsers()
    {
        System.out.println("Before user login method is called");
    }

    @After("execution(* com.learn.day4aop.service.UserActionImpl.userLogin(..))")
    public void afterMethodofUsers()
    {
        System.out.println("After user login method is called");
    }



}
