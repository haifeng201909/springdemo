package com.haifeng.spring.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过xml配置切面
 * @author haifeng
 * @date 2020-08-07 1:27
 */
public class Test {

    public static void main(String[] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");

        MathI math = ac.getBean("mathImpl",MathI.class);

        int res = math.add(1,1);

        System.out.println(res);

    }

}
