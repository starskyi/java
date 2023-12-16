package com.star.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String methodName = url.substring(url.lastIndexOf('/') + 1);
        try{
            this.getClass().getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
