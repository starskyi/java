package com.star.utils;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
    public static void response(HttpServletResponse response, String info){
        try{
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(info);
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
