package com.Husky.superMarket.utils;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/*JDBC工具类*/
public class DBUtil {
    private static ResourceBundle RB=ResourceBundle.getBundle("resources.jdbc");
    private static String url=RB.getString("url");
    private static String driver=RB.getString("driver");
    private static String user=RB.getString("user");
    private static String password=RB.getString("password");
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        Connection conn=DriverManager.getConnection(url,user,password);
        return conn;
    }
    /*关闭资源*/
    public static void close(Connection conn, Statement stat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
