package cn.star.test;

import cn.star.utils.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest2 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils2.getConnection();
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
            JDBCUtils2.close(rs, stmt, con);
            e.printStackTrace();
        }

    }

}
