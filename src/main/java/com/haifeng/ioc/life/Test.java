package com.haifeng.ioc.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-14 23:57
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        // 销毁方法在关闭容器时调用
        ((ClassPathXmlApplicationContext) ac).close();

    }

}
