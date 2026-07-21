package com.learn.day4aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserActionImpl {


    public String userLogin(String userName, String password)
    {

        if(!userName.isBlank())
        {
            return "LOGIN SUCCESSFULL";
        }
        else return "LOGIN FAILED";
    }
}
