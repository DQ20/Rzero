package com.Husky.superMarket.DAOImpl;

import com.Husky.superMarket.DAO.fruitDao;
import com.Husky.superMarket.pojo.Fruit;
import com.Husky.superMarket.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class fruitImpl implements fruitDao {
    @Override
    public List<Fruit> AllFruit() {
        List<Fruit> list =new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from fruits";
        try {
             conn=DBUtil.getConnection();
             ps=conn.prepareStatement(sql);
             rs=ps.executeQuery();
             while (rs.next()){
                Fruit fruit=new Fruit();
                fruit.setName(rs.getString("name"));
                fruit.setNum(rs.getInt("num"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("Unit"));
                fruit.setProductionDate(rs.getDate("productionDate"));
                fruit.setPreservationPeriod(rs.getInt("PreservationPeriod"));
                list.add(fruit);
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
    public List<Fruit> LikeSC(String ipName) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        List<Fruit> list=new ArrayList<>();
        String sql="SELECT * from fruits where name like ?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,"%"+ipName+"%");
            rs=ps.executeQuery();
            while (rs.next()){
                Fruit fruit=new Fruit();
                fruit.setName(rs.getString("name"));
                fruit.setNum(rs.getInt("num"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("Unit"));
                fruit.setProductionDate(rs.getDate("productionDate"));
                fruit.setPreservationPeriod(rs.getInt("PreservationPeriod"));
                list.add(fruit);
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
    public void RemoveFr(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="delete from fruits where name=?";
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
    public void addFr(Fruit fr) {
        String name=fr.getName();
        double price=fr.getPrice();
        int num=fr.getNum();
        Date productionDate=fr.getProductionDate();
        int PreservationPeriod= fr.getPreservationPeriod();
        String Unit= fr.getUnit();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="insert into  fruits (name,price,productionDate,PreservationPeriod,Unit,num)values (?,?,?,?,?,?)";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setDate(3,productionDate);
            ps.setInt(4,PreservationPeriod);
            ps.setString(5,Unit);
            ps.setInt(6,num);
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
    public void mdFr(Fruit fr) {
        String name=fr.getName();
        double price=fr.getPrice();
        int num=fr.getNum();
        java.util.Date productionDate=fr.getProductionDate();
        java.sql.Date date=(java.sql.Date) productionDate;
        int PreservationPeriod= fr.getPreservationPeriod();
        String Unit= fr.getUnit();
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="UPDATE fruits set price=?,productionDate=?,PreservationPeriod=?,Unit=?,num=? where name=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setDouble(1,price);
            ps.setDate(2,date);
            ps.setInt(3,PreservationPeriod);
            ps.setString(4,Unit);
            ps.setInt(5,num);
            ps.setString(6,name);
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
    public Fruit check(String name) {
        Fruit fruit=new Fruit();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from fruits where name=?";
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (rs.next()){
                fruit.setName(rs.getString("name"));
                fruit.setNum(rs.getInt("num"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("Unit"));
                fruit.setProductionDate(rs.getDate("productionDate"));
                fruit.setPreservationPeriod(rs.getInt("PreservationPeriod"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.close(conn,ps,rs);
        }
        return fruit;
    }
    }
