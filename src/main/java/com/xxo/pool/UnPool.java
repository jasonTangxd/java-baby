package com.xxo.pool;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 不使用连接池
 * JDBC DEMO
 * Created by xiaoxiaomo on 2012/4/26.
 */
public class UnPool {

    public static void main(String[] args) {
        // 创建连接
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///xiaoxiaomo?useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
            String sql = "update sys_user set mobile= ? where id = ?";
            statm = conn.prepareStatement(sql) ;
            statm.setString(1,"15826008888");
            statm.setInt(2,2);
            int b = statm.executeUpdate() ;
            if (b == 1) {
                System.out.println("更新成功");
            }

        } catch (Exception e) {
            System.out.println("插入失败");
            e.printStackTrace();
        } finally {
            // 关闭连接 释放资源
            try {
                if (rs != null)
                    rs.close();
                if (statm != null)
                    statm.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
