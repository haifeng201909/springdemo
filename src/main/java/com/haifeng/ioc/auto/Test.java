package com.haifeng.ioc.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-19 19:22
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("auto.xml");

        // 通过ref手动赋值
        Emp emp = ac.getBean("emp", Emp.class);
        System.out.println(emp);

        // byName自动装配
        Emp emp2 = ac.getBean("emp2", Emp.class);
        System.out.println(emp2);

        // byType自动装配
        Emp emp3 = ac.getBean("emp3", Emp.class);
        System.out.println(emp3);

    }

}
