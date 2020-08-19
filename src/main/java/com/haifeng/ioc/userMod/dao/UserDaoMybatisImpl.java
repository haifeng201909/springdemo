package com.haifeng.ioc.userMod.dao;

import org.springframework.stereotype.Repository;

/**
 * @author haifeng
 * @date 2020-07-22 0:33
 */
@Repository
public class UserDaoMybatisImpl implements UserDao {

    public void addUser() {
        System.out.println("UserDaoMybatisImpl: 添加成功");
    }

}
