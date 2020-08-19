package com.haifeng.ioc.userMod.dao;

import org.springframework.stereotype.Repository;

/**
 * @author haifeng
 * @date 2020-07-20 0:21
 */
@Repository
public class UserDaoImpl implements UserDao{

    public void addUser() {
        System.out.println("UserDaoImpl: 添加成功");
    }

    public UserDaoImpl(){
        System.out.println("UserDaoImpl");
    }

}
