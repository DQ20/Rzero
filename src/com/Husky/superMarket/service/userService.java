package com.Husky.superMarket.service;

import com.Husky.superMarket.DAO.userDao;
import com.Husky.superMarket.DAOImpl.userImpl;
import com.Husky.superMarket.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface userService {
    //用户登录
    boolean login(User user);
    //用户注册
    boolean register(User user);
    //用户注销
    void destroy(String account);
    //用户改密
    void modify(String account,String newPassword);

    //查询所有用户信息
    static List<User> QueryAll() {
        userDao ud=new userImpl();
        List<User> list=ud.queryAll();
        return list;
    }
}
