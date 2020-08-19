package com.haifeng.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-09 0:14
 */
public class Test {

    public static void main(String[] args) {

        /**
         * spring中bean作用域：
         * 若spring中有单例模式的bean，则在初始化容器时就会创建此对象
         * 而多例即原型bean，会在使用时创建
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
        /*Student student = ac.getBean("student", Student.class);
        System.out.println(student);
        Student student2 = ac.getBean("student", Student.class);
        System.out.println(student2);
        // equals是object的方法，默认比较的是地址，除非重写了该方法
        System.out.println(student.equals(student2));*/

    }

}
