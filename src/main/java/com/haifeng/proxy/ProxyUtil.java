package com.haifeng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理 要求必须有接口
 *
 * @author haifeng
 * @date 2020-07-24 0:04
 */
public class ProxyUtil {

    // 目标对象
    private MathImpl mathImpl;

    public ProxyUtil(MathImpl mathImpl) {
        this.mathImpl = mathImpl;
    }

    public Object getProxy() {
        /*
        1 获取类加载器
        2 获取目标对象实现的接口的数组
        3 InvocationHandler匿名内部类
         */
        // 获取当前类的类加载器 用来加载代理对象所属类
        ClassLoader loader = this.getClass().getClassLoader();
        // 获取目标对象实现的所有接口Class 代理类会和目标类实现相同的接口 最终通过代理对象实现功能
        Class[] interfaces = mathImpl.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {

            // 代理对象实现功能的方式
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    MyLogger.before(method.getName(), Arrays.toString(args));
                    // 动态代理对象实现功能
                    Object result = method.invoke(mathImpl, args);
                    MyLogger.after(method.getName(), result);
                    return result;
                } catch (Exception e) {
                    MyLogger.throwing();
                    e.printStackTrace();
                } finally {
                    System.out.println("哪都有我");
                }
                return null;
            }
        });
    }

}
