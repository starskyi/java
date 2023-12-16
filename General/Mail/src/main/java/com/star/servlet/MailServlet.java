package com.star.servlet;

import com.star.dao.MailDao;
import com.star.domain.Mail;
import com.star.domain.User;
import com.star.utils.JsonUtil;
import com.star.utils.ResponseUtil;
import com.star.utils.ResultSetUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class MailServlet extends BaseServlet{
    //获取用户所有未读邮件条数
    public void getCount(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String info = "0";
        if(user != null){
            info = new MailDao().findCount(user.getUsername()) + "";
        }

        ResponseUtil.response(response, info);
    }


    public void getMails(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String fieldName = request.getParameter("fieldName");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String info = "";
        if(user == null){
            info = "请登录";
        }else{
            try{
                List list = new MailDao().getMails(fieldName, user.getUsername());
                if(list.size() == 0){
                    info = "{\"flag\":\"error\",\"info\":\"无消息\"}";
                }else{
                    info = JsonUtil.listToJson(list);
                }
            }catch (Exception e){
                e.printStackTrace();
                info = "服务器繁忙";
            }
        }
        ResponseUtil.response(response, info);
    }

    //获取单条邮件
    public void getMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("id");
        String info = "";
        if(user == null){
            info = "请登录";
        }else{
            try{
                int id = Integer.parseInt(sid);
                List list = new MailDao().getMail(id);
                Mail mail = (Mail)list.get(0);
                if(!mail.getSendname().equals(user.getUsername())){
                    new MailDao().updateStatus(id);
                }
                info = JsonUtil.listToJson(list);
            }catch (Exception e){
                e.printStackTrace();
                info = "服务器繁忙";
            }
        }
        ResponseUtil.response(response, info);
    }

    //发送邮件
    public void sendMail(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	request.setCharacterEncoding("utf-8");
    	String sendname = request.getParameter("sendname");
    	String receivename = request.getParameter("receivename");
    	String theme = request.getParameter("theme");
    	String context = request.getParameter("context");
    	MailDao mailDao = new MailDao();
    	Mail mail = new Mail(0, sendname, receivename, theme, context,"", 0);
    	int result = mailDao.addMail(mail);
    	response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
        String message = "";
    	if(result == 1){
    		//添加成功
            message = "1";
    	}else{
    		//添加失败
    		message = "0";
    	}
    	ResponseUtil.response(response, message);
    }

    public void delMails(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String[] ids = request.getParameterValues("id");
        int result = new MailDao().delMails(ids);
        String info = "";
        if(result != 0){
            info = "删除成功";
        }else{
            info = "删除失败";
        }
        ResponseUtil.response(response, info);
    }
}
