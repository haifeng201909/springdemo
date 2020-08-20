package com.haifeng.book.dao.impl;

import com.haifeng.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author haifeng
 * @date 2020-08-21 0:32
 */

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询价格
     * @param bid
     * @return
     */
    @Override
    public Integer selectPrice(String bid) {
        String sql = "select price from book where bid = ?";
        Integer price = jdbcTemplate.queryForObject(sql, new Object[]{bid}, Integer.class);
        return price;
    }

    /**
     * 更新书籍库存
     * @param bid
     */
    @Override
    public void updateSt(String bid) {
        // 获取书籍库存
        String sqlForQuery = "select st from stock where sid = ?";
        String sqlForUpdate = "update stock set st = st - 1 where sid = ?";
        Integer st = jdbcTemplate.queryForObject(sqlForQuery, new Object[]{bid}, Integer.class);
        if (st <= 0){
            throw new RuntimeException();
        }else {
            // 更新数据库
            jdbcTemplate.update(sqlForUpdate, bid);
        }
    }

    /**
     * 更新余额
     * @param uid
     * @param price
     */
    @Override
    public void updateBalance(String uid, Integer price) {
        // 查询余额
        String sqlForQuery = "select balance from money where uid = ?";
        String sqlForUpdate = "update money set balance = balance - ? where uid = ?";
        Integer balance = jdbcTemplate.queryForObject(sqlForQuery, new Object[]{uid}, Integer.class);
        if(balance < price){
            throw new RuntimeException();
        }else{
            jdbcTemplate.update(sqlForUpdate, price, uid);
        }
    }
}
