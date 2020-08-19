package com.haifeng.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author haifeng
 * @date 2020-08-03 23:54
 */
@Component
public class MathImpl implements MathI {
    public int add(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}