package com.haifeng.book;

import com.haifeng.book.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haifeng
 * @date 2020-08-21 1:11
 */
public class Test {

    public static void main(String[] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");

        BookController bookController = ac.getBean("bookController", BookController.class);

        bookController.buyBook();

    }

}
