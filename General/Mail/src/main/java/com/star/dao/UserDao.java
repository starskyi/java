package com.star.dao;
import java.sql.*;

import com.star.utils.*;

public class UserDao {

	public Statement stat = JDBCUtil.getStatement();

	//添加
	public int add(String username, String password){
		String sql = "insert into tb_user values('" + username+ "','" + password +"')";
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	//删除
	public int delete(int id){
		String sql = "delete from tb_user where id = " + id;
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	//查询所有
	public ResultSet query(){
		String sql = "select * from tb_user";
		try{
			return stat.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	//查询单个
	public ResultSet findById(int id){
		String sql = "select * from tb_user where id = " + id;
		try{
			return stat.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//修改
	public int update(int id, String username, String password){
		String sql = "update tb_user set username = '" + username + "', password = '" + password + "'" + "where id = " + id;
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}

	//查询单个
	public ResultSet findUser(String username, String password){
		String sql = "select * from tb_user where username = '" + username + "' and password = '" + password + "'";
		try{
			return stat.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
