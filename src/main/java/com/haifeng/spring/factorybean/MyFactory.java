package com.haifeng.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author haifeng
 * @date 2020-07-08 23:37
 */
public class MyFactory implements FactoryBean<Car> {

    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand("奥迪");
        car.setPrice(200000.0);
        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     *
     */
    public boolean isSingleton() {
        return false;
    }
}
