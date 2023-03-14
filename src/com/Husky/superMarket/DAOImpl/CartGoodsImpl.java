package com.Husky.superMarket.DAOImpl;

import com.Husky.superMarket.DAO.CartGoodsDao;
import com.Husky.superMarket.pojo.CartGoods;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartGoodsImpl implements CartGoodsDao {
    @Override
    public void delC(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="delete from cart where name=?";
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,null);
        }
    }
    @Override
    public List<CartGoods> checkAll() {
        List<CartGoods> list =new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from cart";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                CartGoods cart=new CartGoods();
                cart.setName(rs.getString("name"));
                cart.setNum(rs.getInt("num"));
                cart.setPrice(rs.getDouble("price"));
                list.add(cart);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,rs);
        }
        return list;
    }

    @Override
    public void add(CartGoods goods) {
        String name=goods.getName();
        double price=goods.getPrice();
        int num=goods.getNum();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="insert into  cart (name,price,num)values (?,?,?)";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,num);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
    }

    @Override
    public void delAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="delete from cart";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,null);
        }
    }

    @Override
    public CartGoods check(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from  cart where name=?";
        CartGoods cg=new CartGoods();
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                cg.setPrice(rs.getDouble("price"));
                cg.setNum(rs.getInt("num"));
                cg.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return cg;
    }

    @Override
    public void modifyC(CartGoods cartGoods) {
        String name=cartGoods.getName();
        int num=cartGoods.getNum();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="update cart set num=? where name=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setDouble(1,num);
            ps.setString(2,name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
    }
}
