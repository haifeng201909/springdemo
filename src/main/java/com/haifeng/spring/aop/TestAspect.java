package com.haifeng.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试@Order注解 设置切面优先级
 * @author haifeng
 * @date 2020-08-07 1:19
 */
@Component
@Aspect
@Order(0)
public class TestAspect {

    @Before(value = "execution(* com.haifeng.spring.aop.*.*(..))")
    public void beforeMethod(){
        System.out.println("TestAspect===>前置通知");
    }

}
