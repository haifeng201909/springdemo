package com.haifeng.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author haifeng
 * @date 2020-07-15 0:23
 */
public class AfterHandler implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Person person = (Person) bean;
        if(person.getSex().endsWith("男")){
            person.setName("张无忌");
        }else {
            person.setName("赵敏");
        }
        return person;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
