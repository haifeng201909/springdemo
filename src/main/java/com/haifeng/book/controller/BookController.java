package com.haifeng.book.controller;

import com.haifeng.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author haifeng
 * @date 2020-08-21 0:28
 */

@Controller
public class BookController {

    @Autowired
    private BookService service;

    public void buyBook() {
        service.buyBook("1", "1001");
    }

}
