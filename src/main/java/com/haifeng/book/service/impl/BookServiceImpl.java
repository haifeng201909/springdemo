package com.haifeng.book.service.impl;

import com.haifeng.book.dao.BookDao;
import com.haifeng.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haifeng
 * @date 2020-08-21 0:30
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    @Override
    public void buyBook(String bid, String uid) {
        Integer price = dao.selectPrice(bid);
        dao.updateSt(bid);
        dao.updateBalance(uid, price);
    }
}
