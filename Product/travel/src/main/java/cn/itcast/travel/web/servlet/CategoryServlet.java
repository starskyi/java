// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CategoryServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import cn.itcast.travel.util.ResponseUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Referenced classes of package cn.itcast.travel.web.servlet:
//            BaseServlet

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet
{

    public CategoryServlet()
    {
        service = new CategoryServiceImpl();
    }

    public void findAll(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        java.util.List list = service.findAll();
        ResponseUtils.response(list, resp);
    }

    private CategoryService service;
}
