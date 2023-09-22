// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JDBCUtils.java

package cn.itcast.travel.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;

public class JDBCUtils
{

    public JDBCUtils(){
    }

    public static DataSource getDataSource()
    {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null)
            try {
                rs.close();
            } catch(SQLException sqlexception) { }
        if(stmt != null)
            try {
                stmt.close();
            } catch(SQLException sqlexception1) { }
        if(conn != null)
            try {
                conn.close();
            } catch(SQLException sqlexception2) { }
    }

    public static void close(Connection conn, Statement stmt)
    {
        close(conn, stmt, null);
    }

    private static DataSource ds;

    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pp = new Properties();
        try{
            pp.load(is);
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
