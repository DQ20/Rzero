package com.Husky.superMarket.serviceImpl;

import com.Husky.superMarket.DAO.userDao;
import com.Husky.superMarket.DAOImpl.userImpl;
import com.Husky.superMarket.pojo.User;
import com.Husky.superMarket.service.userService;
import jakarta.servlet.http.HttpServlet;

import java.util.List;

public class userServiceImpl implements userService {

    userDao ud=new userImpl();

    @Override
    public boolean login(User user) {
        User u=ud.checkUser(user.getAccount());
        boolean success=false;
        if(u!=null&&u.equals(user)){
            success=true;
        }
        return success;
    }

    @Override
    public boolean register(User user) {
        boolean success=false;
        if(ud.checkUser(user.getAccount())==null){
            ud.addUser(user);
            success=true;
        }
        return success;
    }

    @Override
    public void destroy(String account) {
        ud.removeUser(account);
    }

    @Override
    public void modify(String account, String newPassword) {
        ud.updatePw(account,newPassword);
    }

}
