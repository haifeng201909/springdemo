package com.haifeng.spring.aopxml;

import org.springframework.stereotype.Component;

/**
 * @author haifeng
 * @date 2020-08-07 1:27
 */
@Component
public class MyLogger {

    public void before(){
        System.out.println("前置通知");
    }

}
