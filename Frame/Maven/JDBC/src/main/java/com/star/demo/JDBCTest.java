package com.star.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Star";
        Connection con = DriverManager.getConnection(url, "sa", "123456");
        System.out.println(con);
    }
}
