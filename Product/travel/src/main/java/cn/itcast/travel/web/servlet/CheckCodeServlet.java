// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CheckCodeServlet.java

package cn.itcast.travel.web.servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CheckCodeServlet extends HttpServlet
{

    public CheckCodeServlet()
    {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        String checkCode = getCheckCode();
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("\u9ED1\u4F53", 1, 24));
        g.drawString(checkCode, 15, 25);
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    private String getCheckCode()
    {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= 4; i++)
        {
            int index = r.nextInt(size);
            char c = base.charAt(index);
            sb.append(c);
        }

        return sb.toString();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }
}
