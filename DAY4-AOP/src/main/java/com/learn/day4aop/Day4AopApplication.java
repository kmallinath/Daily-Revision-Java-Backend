package com.learn.day4aop;

import com.learn.day4aop.service.UserActionImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Day4AopApplication implements CommandLineRunner {

    @Autowired
    private UserActionImpl userService;

    public static void main(String[] args)  {
        SpringApplication.run(Day4AopApplication.class, args);
    }

    @Override    
    public void run(String... args) throws Exception {
        // Application startup logic

        userService.userLogin("malli","malli");

    }
}
