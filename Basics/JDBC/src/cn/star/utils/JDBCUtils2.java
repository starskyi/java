package cn.star.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils2 {
    private static DataSource ds;

    static{
        try {

            Properties p = new Properties();
            //加载配置文件
            p.load(JDBCUtils2.class.getClassLoader().getResourceAsStream("db.properties"));

            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
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
