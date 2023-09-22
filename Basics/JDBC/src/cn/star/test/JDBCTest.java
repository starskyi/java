package cn.star.test;

import cn.star.utils.JDBCUtils;

import java.sql.*;

public class JDBCTest{
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from seller";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            JDBCUtils.close(rs, stmt, con);
            e.printStackTrace();
        }

    }

}
