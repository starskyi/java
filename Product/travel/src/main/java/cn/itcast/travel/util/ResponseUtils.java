// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ResponseUtils.java

package cn.itcast.travel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtils
{

    public ResponseUtils()
    {
    }

    public static void response(Object info, HttpServletResponse resp)
    {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try
        {
            json = mapper.writeValueAsString(info);
        }
        catch(JsonProcessingException e)
        {
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        try
        {
            resp.getWriter().write(json);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
