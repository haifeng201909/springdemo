package com.haifeng.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author haifeng
 * @date 2020-08-04 1:00
 */
@Component
public class TestHandler {

    public void test(){
        System.out.println("测试切入点表达式");
    }

}
