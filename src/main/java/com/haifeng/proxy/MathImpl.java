package com.haifeng.proxy;

/**
 * @author haifeng
 * @date 2020-07-23 23:48
 */
public class MathImpl implements MathI{
    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
