package com.fang7.java.transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {
    //数据库连接地址
    public final static String URL = "jdbc:mysql://hadoop101:3306/java_test";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "XIEziang123";
    //驱动类
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        insertAndQuery();
    }
    //方法：使用PreparedStatement插入数据、更新数据
    public static void insertAndQuery(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //设置为手动提交事务
            conn.setAutoCommit(false);
            String sql1 = "insert into user(name,pwd)values(?,?)";
            String sql2 = "update user set pw2d=? where name=?";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, "smyhvae");
            ps.setString(2, "222222");
            ps.executeUpdate();

            ps = conn.prepareStatement(sql2);
            ps.setString(1, "008");
            ps.setString(2, "smyh");
            ps.executeUpdate();
            //如果所有sql语句成功，则提交事务
            conn.commit();
            ps.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();//只要有一个sql语句出现错误，则将事务回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

