// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BaseServlet.java

package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class BaseServlet extends HttpServlet {

    public BaseServlet() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        try {
            this.getClass().getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class
            ).invoke(this, req, resp);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
