// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CategoryServiceImpl.java

package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.inpl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import java.util.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class CategoryServiceImpl implements CategoryService {

    public CategoryServiceImpl()
    {
        dao = new CategoryDaoImpl();
    }

    public List findAll() {
        Jedis jedis = null;
        try {
            jedis = JedisUtil.getJedis();
        } catch(Exception exception) { }
        if(jedis == null)
            return dao.findAll();
        Set category = jedis.zrangeWithScores("category", 0L, -1L);
        List list = null;
        if(category != null && category.size() > 0) {
            list = new ArrayList();
            Category ca = new Category();
            for(Iterator iterator1 = category.iterator(); iterator1.hasNext(); list.add(ca)) {
                Tuple tuple = (Tuple)iterator1.next();
                ca.setCname(tuple.getElement());
                ca.setCid((int)tuple.getScore());
            }

        } else {
            list = dao.findAll();
            Category ca;
            for(Iterator iterator = list.iterator(); iterator.hasNext(); jedis.zadd("category", ca.getCid(), ca.getCname()))
                ca = (Category)iterator.next();

        }
        return list;
    }

    private CategoryDao dao;
}
