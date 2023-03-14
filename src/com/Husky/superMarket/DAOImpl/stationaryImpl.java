package com.Husky.superMarket.DAOImpl;

import com.Husky.superMarket.DAO.stationaryDao;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.pojo.stationary;
import com.Husky.superMarket.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class stationaryImpl implements stationaryDao {
    @Override
    public List<stationary> AllSt() {
        List<stationary> list =new ArrayList<>();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from stationary";
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                stationary st=new stationary();
                st.setName(rs.getString("name"));
                st.setNum(rs.getInt("num"));
                st.setPrice(rs.getDouble("price"));
                st.setUnit(rs.getString("Unit"));
                st.setProductPlace(rs.getString("ProductPlace"));
                list.add(st);
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
    public List<stationary> LikeSC(String ipName) {
        List<stationary> list =new ArrayList<>();

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * from stationary where name like ?";
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,"%"+ipName+"%");
            rs=ps.executeQuery();
            while (rs.next()){
                stationary st=new stationary();
                st.setName(rs.getString("name"));
                st.setNum(rs.getInt("num"));
                st.setPrice(rs.getDouble("price"));
                st.setUnit(rs.getString("Unit"));
                st.setProductPlace(rs.getString("ProductPlace"));
                list.add(st);
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
    public void RemoveSt(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="delete from stationary where name=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,null);
        }
    }

    @Override
    public void addSt(stationary st) {
        String name=st.getName();
        double price=st.getPrice();
        int num=st.getNum();
        String Unit= st.getUnit();
        String pp=st.getProductPlace();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="insert into  stationary (name,price,Unit,num,ProductPlace)values (?,?,?,?,?)";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setString(3,Unit);
            ps.setInt(4,num);
            ps.setString(5,pp);
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
    public void mdSt(stationary st) {
        String name=st.getName();
        double price=st.getPrice();
        int num=st.getNum();
        String Unit= st.getUnit();
        String pp=st.getProductPlace();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="UPDATE stationary set price=?,Unit=?,num=?,ProductPlace=? where name=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setDouble(1,price);
            ps.setString(2,Unit);
            ps.setInt(3,num);
            ps.setString(4,pp);
            ps.setString(5,name);
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
    public stationary check(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from stationary where name=?";
        stationary st=null;
        try {
            conn= DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (rs.next()){
                st=new stationary();
                st.setName(rs.getString("name"));
                st.setNum(rs.getInt("num"));
                st.setPrice(rs.getDouble("price"));
                st.setUnit(rs.getString("Unit"));
                st.setProductPlace(rs.getString("ProductPlace"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,rs);
        }
        return st;
    }
}
