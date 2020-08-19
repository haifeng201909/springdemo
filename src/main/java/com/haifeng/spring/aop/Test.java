package com.haifeng.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1、在配置文件中配置包的扫描
 * 2、配置文件中配置自动代理 <aop:aspectj-autoproxy proxy-target-class="true"/>
 * 3、在切面中定义注解 @Aspect 以及 @Component
 * 4、切面中定义通知 @Before(value = "execution(public int com.haifeng.spring.aop.MathImpl.add(int, int))")
 * 5、对象的获取需要从容器中获取，不能自己new
 *
 * 注意：要想AOP生效，需要使用Spring一整套组件
 *
 * Spring的AOP默认使用JDK动态代理，这就要求被代理的类需要实现接口
 * 但是没有实现接口也是可以的，因为Spring会尝试使用cglig动态代理
 *
 * @author haifeng
 * @date 2020-08-04 0:12
 */
public class Test {

    public static void main(String[] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        MathI math = ac.getBean("mathImpl", MathI.class);

        int result = math.add(1,2);
        System.out.println(result);

        int div = math.div(1, 1);
        System.out.println(div);

        // 用于测试 @Before(value = "execution(* com.haifeng.spring.aop.*.*(..))") 功能
        TestHandler testHandler = ac.getBean("testHandler", TestHandler.class);
        testHandler.test();

    }

}
