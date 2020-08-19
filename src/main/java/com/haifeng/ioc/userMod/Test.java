package com.haifeng.ioc.userMod;

import com.haifeng.ioc.userMod.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-07-20 0:25
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");

        // 此处证明 Spring会在配置文件中自动生成id为userController的bean
        // 否则此处无法获取uc对象
        UserController uc = ac.getBean("aaa", UserController.class);
        System.out.println(uc);

        uc.addUser();
    }

}
