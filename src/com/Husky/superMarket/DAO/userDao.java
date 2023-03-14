package com.Husky.superMarket.DAO;

import com.Husky.superMarket.pojo.User;

import java.util.List;

public interface userDao {
    public User checkUser(String account);
    public int addUser(User user);
    public int removeUser(String account);
    public int updatePw(String account,String newPassword);
    public List<User> queryAll();
}
