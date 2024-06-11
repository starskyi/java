package com.star.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.star.utils.JDBCUtil;
public class ShopDao {
    public Statement stat = JDBCUtil.getStatement();
    public ResultSet query(){
        String sql = "select * from Product";
        try{
            return stat.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public int update(String productName){
        String sql = "update Product set statu = '" + 0 + "'" + " where productName = '" +  productName + "'";
        try{
            return stat.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public ResultSet queryByName(String username){
        String sql = "select * from Product where selectBy = '" + username + "'";
        try{
            return stat.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
