package com.haifeng.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-07 22:16
 */
public class SpringTest {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = (Student) ac.getBean("studentOne");
        System.out.println(student);

        Student student2 = (Student) ac.getBean("studentTwo");
        System.out.println(student2);

        Student student3 = (Student) ac.getBean("studentThree");
        System.out.println(student3);

        // id + class
        Teacher t1 = ac.getBean("t1", Teacher.class);
        System.out.println(t1);

        // List
        Teacher t2 = ac.getBean("t2", Teacher.class);
        System.out.println(t2);

        // Array
        Teacher t3 = ac.getBean("t3", Teacher.class);
        System.out.println(t3);

        // Set
        Teacher t4 = ac.getBean("t4", Teacher.class);
        System.out.println(t4);

        Teacher t5 = ac.getBean("t5", Teacher.class);
        System.out.println(t5);
    }

}
