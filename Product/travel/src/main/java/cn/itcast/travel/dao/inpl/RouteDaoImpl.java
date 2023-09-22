// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteDaoImpl.java

package cn.itcast.travel.dao.inpl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.util.JDBCUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RouteDaoImpl
    implements RouteDao
{

    public RouteDaoImpl()
    {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    public int findTotalCount(int cid, String rname)
    {
        String sql = "select count(*) from route where 1 = 1 ";
        StringBuilder builder = new StringBuilder();
        builder.append(sql);
        List list = new ArrayList();
        if(cid > 0)
        {
            builder.append(" and cid = ? ");
            list.add(Integer.valueOf(cid));
        }
        if(rname != null && rname.length() > 0 && !rname.equals("null"))
        {
            builder.append(" and rname like ? ");
            list.add((new StringBuilder()).append("%").append(rname).append("%").toString());
        }
        sql = builder.toString();
        int totalCount = ((Integer)template.queryForObject(sql, Integer.class, list.toArray())).intValue();
        return totalCount;
    }

    public List findAll(int cid, int start, int pageSize, String rname)
    {
        String sql = "select * from route where 1 = 1 ";
        StringBuilder builder = new StringBuilder();
        builder.append(sql);
        List list = new ArrayList();
        if(cid > 0)
        {
            builder.append(" and cid = ? ");
            list.add(Integer.valueOf(cid));
        }
        if(rname != null && rname.length() > 0 && !rname.equals("null"))
        {
            builder.append(" and rname like ? ");
            list.add((new StringBuilder()).append("%").append(rname).append("%").toString());
        }
        builder.append(" limit ?, ? ");
        list.add(Integer.valueOf(start));
        list.add(Integer.valueOf(pageSize));
        sql = builder.toString();
        return template.query(sql, new BeanPropertyRowMapper(Route.class), list.toArray());
    }

    public Route findOne(int rid)
    {
        String sql = "select * from route where rid = ?";
        Route route = null;
        try
        {
            route = (Route)template.queryForObject(sql, new BeanPropertyRowMapper(Route.class), new Object[] {
                Integer.valueOf(rid)
            });
        }
        catch(Exception e)
        {
            System.out.println("route \u8FD4\u56DE\u9519\u8BEF");
            e.printStackTrace();
        }
        return route;
    }

    public List findRouteImg(int rid)
    {
        String sql = "select * from route_img where rid = ?";
        List routeImgs = null;
        try
        {
            routeImgs = template.query(sql, new BeanPropertyRowMapper(RouteImg.class), new Object[] {
                Integer.valueOf(rid)
            });
        }
        catch(Exception e)
        {
            System.out.println("routeImgs \u8FD4\u56DE\u9519\u8BEF");
            e.printStackTrace();
        }
        return routeImgs;
    }

    public Seller findSeller(int sid)
    {
        String sql = "select * from seller where sid = ?";
        return (Seller)template.queryForObject(sql, new BeanPropertyRowMapper(Seller.class), new Object[] {
            Integer.valueOf(sid)
        });
    }

    public int findCollectCount(int rid)
    {
        String sql = "select count(*) from favorite where rid = ?";
        return ((Integer)template.queryForObject(sql, Integer.class, new Object[] {
            Integer.valueOf(rid)
        })).intValue();
    }

    private JdbcTemplate template;
}
