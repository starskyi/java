package com.star.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.star.utils.JDBCUtil;

public class BookDao {
	public Statement stat = JDBCUtil.getStatement();

	//查询所以书籍
	public ResultSet query(){
		String sql = "select * from books";
		try{
			return stat.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	//查询单个书籍
	public ResultSet findById(int id){
		String sql = "select * from books where id = " + id;
		try{
			return stat.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//修改书籍
	public int update(int id, String name, String author){
		String sql = "update books set name = '" + name + "', author = '" + author + "'" + "where id = " + id;
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}

	//删除书籍
	public int delete(int id){
		String sql = "delete from books where id = " + id;
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	//添加书籍
	public int add(String name, String author){
		String sql = "insert into books values('" + name+ "','" + author + "')";
		try{
			return stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
