package com.haifeng.book.dao;

/**
 * @author haifeng
 * @date 2020-08-21 0:31
 */
public interface BookDao {

    Integer selectPrice(String bid);

    void updateSt(String bid);

    void updateBalance(String uid, Integer price);

}
