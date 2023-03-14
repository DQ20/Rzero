package com.Husky.superMarket.DAOImpl;


import com.Husky.superMarket.DAO.userDao;
import com.Husky.superMarket.pojo.User;
import com.Husky.superMarket.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userImpl implements userDao {

    //查询一条信息
    @Override
    public User checkUser(String account){
        User user=null;
        Connection conn= null;
        String sql="select * from users where account=?";
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            rs=ps.executeQuery();
            if (rs.next()){
                user=new User();
                user.setAccount(account);
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,rs);
        }
        return user;
        }

    //插入数据
    @Override
    public int addUser(User user){
        Connection conn= null;
        int count=0;
        PreparedStatement ps=null;
        String sql="insert into users (account,password) value(?,?)";
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
            count=ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    //删除数据
    @Override
    public int removeUser(String account){
        Connection conn= null;
        String sql="delete from users where account=?";
        int count=0;
        PreparedStatement ps=null;
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            count=ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    //修改数据
    @Override
    public int updatePw(String account, String newPassword){
        Connection conn= null;
        String sql="update users set password=? where account=?";
        PreparedStatement ps=null;
        int count=0;
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,newPassword);
            ps.setString(2,account);
            count=ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }
    //查询所有数据
    @Override
    public List<User> queryAll(){
        List<User> list=new ArrayList<>();

        Connection conn= null;
        PreparedStatement ps=null;
        String sql="select * from users";
        ResultSet rs=null;
        try {
            conn = DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setAccount(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return list;
    }
}
