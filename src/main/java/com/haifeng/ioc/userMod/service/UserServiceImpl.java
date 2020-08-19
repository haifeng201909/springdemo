package com.haifeng.ioc.userMod.service;

import com.haifeng.ioc.userMod.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author haifeng
 * @date 2020-07-20 0:20
 */
@Service
public class UserServiceImpl implements UserService{

    // required = false 表示允许不自动装配，默认值为true
    // @Qualifier注解用来指定bean的id
    @Autowired(required = true)
//    @Qualifier(value = "userDaoImpl")
    @Qualifier(value = "userDaoMybatisImpl")
    private UserDao userDao;

    // 此处注解作用于入参
    @Autowired
    @Qualifier(value = "userDaoMybatisImpl")
    public void ghfsetUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public UserServiceImpl(){
        System.out.println("UserServiceImpl");
    }

    public void addUser() {
        userDao.addUser();
    }
}
