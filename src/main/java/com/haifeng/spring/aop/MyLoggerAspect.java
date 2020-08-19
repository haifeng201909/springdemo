package com.haifeng.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author haifeng
 * @date 2020-08-04 0:03
 */
@Aspect // 标注当前类为切面
@Component
@Order(1) //定义切面作用的优先级，值越小优先级越高，默认为int的最大值
public class MyLoggerAspect {

    /**
     * 重用切入点 使用方式见@Before
     * 定义公共的切入点
     */
    @Pointcut("execution(* com.haifeng.spring.aop.*.*(..))")
    public void test(){ }

    /**
     * @Before 将方法指定为前置通知 作用于方法执行之前
     * 必须设置value，其值为切入点表达式
     * 方法中的信息会封装到JoinPoint对象中
     * <p>
     * 第一个 * 表示所有的权限修饰符以及返回值
     * 第二个 * 表示任意的类
     * 第三个 * 表示任意的方法
     * 第四个 .. 表示任意的参数列表
     */
//    @Before(value = "execution(public int com.haifeng.spring.aop.MathImpl.add(int, int))")
//    @Before(value="execution(public int com.haifeng.spring.aop.MathImpl.*(int, int))")
//    @Before(value = "execution(* com.haifeng.spring.aop.*.*(..))")
    @Before(value = "test()")
    public void beforeMethod(JoinPoint joinPoint) {
        // 获取方法的参数
        Object[] args = joinPoint.getArgs();

        // 获取方法名 joinPoint.getSignature()获取签名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("方法执行之前");
        System.out.println("method: " + methodName + ", arguments: " + Arrays.asList(args));
    }

    /**
     * @After 将方法指定为后置通知 作用于方法的finally语句块
     * 后置通知无论是否有异常，都会执行，类似于finally
     */
    @After(value = "execution(* com.haifeng.spring.aop.*.*(..))")
    public void afterMethod() {
        System.out.println("后置通知");
    }


    /**
     *
     * @AfterReturning 将方法标注为返回通知 作用于方法执行之后
     * 可通过returning设置接收方法返回值的变量名
     * 要想在方法中使用，必须在方法的形参中设置和变量名相同的参数名的参数
     *
     * 如果没有异常，则会执行该注解修饰的方法，如果有异常则不会执行
     * <p>
     * returning属性 会将返回返回结果赋值给result，其类型为Object
     * 此处result相当于接收方法返回值的变量名
     */
    @AfterReturning(value = "execution(* com.haifeng.spring.aop.*.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("返回通知");
        System.out.println("method: " + methodName + ",result: " + result);
    }


    /**
     * @AfterThrowing 将方法标注为异常通知（也叫做例外通知） 作用于方法抛出异常时
     * 通过throwing设置方法返回的异常信息
     * 在参数列表中通过具体的异常类型，来对指定的异常信息进行操作
     *
     * 通过定义异常的类型，可以实现匹配指定异常
     * 例如，此处若定义NullPointerException，而实际为数学运行异常，则该方法就不会执行
     * @param ex
     */
    @AfterThrowing(value = "execution(* com.haifeng.spring.aop.*.*(..))", throwing = "ex")
    public void afterThrowingMethod(ArithmeticException ex){
        System.out.println("出现异常, messages: " + ex);
    }


    /**
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "execution(* com.haifeng.spring.aop.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){

        Object result = null;

        try {
            // 前置通知
            // ...
            System.out.println("aroundMethod: 前置通知");

            result = joinPoint.proceed(); // 执行方法

            // 返回通知
            // ...
            System.out.println("aroundMethod: 返回通知");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
            // ...
            System.out.println("aroundMethod: 异常通知");
        } finally {
            // 后置通知
            // ...
            System.out.println("aroundMethod: 后置通知");
        }

        return -1;
    }

}
