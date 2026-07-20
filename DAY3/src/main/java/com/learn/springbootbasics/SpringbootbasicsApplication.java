package com.learn.springbootbasics;

import com.learn.springbootbasics.proxies.Car;
import com.learn.springbootbasics.proxies.CarInterfaceInvocationHandler;
import com.learn.springbootbasics.proxies.Skoda;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Proxy;

@SpringBootApplication
public class SpringbootbasicsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbasicsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /**
         *  How proxies work
         */

        Skoda s = new Skoda();

        ClassLoader carClassLoader =s.getClass().getClassLoader();
        Class[] interfaces=s.getClass().getInterfaces();
        Car proxy= (Car) Proxy.newProxyInstance(carClassLoader,interfaces,new CarInterfaceInvocationHandler(s));
        proxy.getColor();
        System.out.println(s.getColor());

    }
}
