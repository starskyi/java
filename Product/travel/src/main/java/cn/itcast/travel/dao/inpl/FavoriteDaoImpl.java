// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FavoriteDaoImpl.java

package cn.itcast.travel.dao.inpl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteDaoImpl
    implements FavoriteDao
{

    public FavoriteDaoImpl()
    {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    public Favorite findByRidAndUid(int rid, int uid)
    {
        String sql = "select * from favorite where rid = ? and uid = ?";
        return (Favorite)template.queryForObject(sql, new BeanPropertyRowMapper(Favorite.class), new Object[] {
            Integer.valueOf(rid), Integer.valueOf(uid)
        });
    }

    public void add(int rid, int uid)
    {
        String sql = "insert into favorite values(?,?,?)";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(date);
        template.update(sql, new Object[] {
            Integer.valueOf(rid), dateStr, Integer.valueOf(uid)
        });
    }

    private JdbcTemplate template;
}
