package cn.star.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static{
        try {

            Properties p = new Properties();
            //加载配置文件
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));

            //获取参数
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            driver = p.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //关闭资源
    public static void close(ResultSet rs, Statement stmt, Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
