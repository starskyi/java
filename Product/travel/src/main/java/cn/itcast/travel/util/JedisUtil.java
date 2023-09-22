// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JedisUtil.java

package cn.itcast.travel.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import redis.clients.jedis.*;

public final class JedisUtil
{

    public JedisUtil()
    {
    }

    public static Jedis getJedis()
    {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis)
    {
        if(jedis != null)
            jedis.close();
    }

    private static JedisPool jedisPool;

    static 
    {
        InputStream is = JedisPool.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try
        {
            pro.load(is);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }
}
