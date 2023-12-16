package com.star.dao;

import com.star.domain.Mail;
import com.star.utils.JDBCUtil;
import com.star.utils.ResultSetUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MailDao {
    public Statement stat = JDBCUtil.getStatement();

    //查询用户未读邮件条数
    public int findCount(String username){
        String sql = "select count(*) from mails where receivename = '"
                + username + "' and status = 0";

        try{
            ResultSet resultSet = stat.executeQuery(sql);
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //查询用户所用收发邮件
    public List<Mail> getMails(String fieldName, String username){
        String sql = "select * from mails where " + fieldName + " = '"
                + username + "'";
        try{
            ResultSet resultSet = stat.executeQuery(sql);
            return ResultSetUtil.getList(resultSet, Mail.class);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //根据id获取单条邮件
    public List<Mail> getMail(int id){
        String sql = "select * from mails where id = " + id;
        try{
            ResultSet resultSet = stat.executeQuery(sql);
            return ResultSetUtil.getList(resultSet, Mail.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    //更新阅读状态信息
    public int updateStatus(int id){
        String sql = "update mails set status = 1 where id = " + id;
        try{
            return stat.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    //添加邮件
    public int addMail(Mail mail){
    	String sql = "insert into mails values('" + mail.getSendname() + "','" 
    	+ mail.getReceivename() + "','" 
    	+ mail.getTheme() + "','" + mail.getContext()
        + "',convert(varchar,getdate(),120)" + ", 0)";
    	
    	try{
    		return stat.executeUpdate(sql);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }

    public int delMails(String[] ids){
        String sql = "delete from mails where id in(";
        for(String id : ids){
            sql += id + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += ")";
        try{
            return stat.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
