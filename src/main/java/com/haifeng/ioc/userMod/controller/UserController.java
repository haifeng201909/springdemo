package com.haifeng.ioc.userMod.controller;

import com.haifeng.ioc.userMod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author haifeng
 * @date 2020-07-20 0:16
 *
 * 基于注解的组件化管理：
 * @Component @Controller（控制层） @Service（业务层） @Repository（持久层）
 * 以上四个注解功能完全相同，不过在实际开发过程中，要在实现不同功能的类上加上相应的注解
 *
 * 完成组件化管理的过程：
 * 1、在需要被spring管理的类上加上相应的注解
 * 2、在配置文件中通过<context:component-scan>对所设置的包结构进行扫描，
 *    就会将加上注解的类，作为spring的组件进行加载
 *    组件 指Spring中管理的bean
 *    作为Spring的组件进行加载 会自动在Spring的配置文件中生成相对应的bean，这些bean的id会以类的首字母小写为值；
 *    也可以通过@Controller("beanId")为自动生成的bean指定id
 *
 * 自动装配：在需要赋值的非字面量属性上，加上@Autowired，就可以在Spring容器中，通过不同的方式匹配到对应的bean
 * @Autowired 装配时，会默认使用byType的方式，此时要求Spring容器中只能有一个能够为其赋值
 * 当byType实现不了装配时，会自动切换到byName，此时要求Spring容器中，有一个bean的id与属性名一致
 * 若自动装配时，匹配到多个能够赋值的bean，可使用@Qualifier(value="beanId")指定使用的bean
 * @Autowired 和 @Qualifier(value=""beanId)可以一起作用于一个带形参的方法上，此时@Qualifier(value=""beanId)
 * 所指定的bean作用于形参
 *
 */
// value表示默认生成的bean的id
@Controller(value = "aaa")
//@Controller
public class UserController {

    // @Autowired是根据类型自动装配的 如果接口有两个实现类 运行就会报错
    // No qualifying bean of type 'com.haifeng.ioc.userMod.dao.UserDao' available: expected single matching bean but found 2: userDaoImpl,userDaoImpl2
    @Autowired
    private UserService userService;

    public void addUser(){
        userService.addUser();
    }

    public UserController(){
        System.out.println("UserController");
    }

}
