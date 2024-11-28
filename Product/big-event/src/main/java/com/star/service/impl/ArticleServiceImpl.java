package com.star.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.star.mapper.ArticleMapper;
import com.star.pojo.Article;
import com.star.pojo.PageBean;
import com.star.service.ArticleService;
import com.star.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();

        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        //获取当前用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> list = articleMapper.list(userId, categoryId, state);

        Page<Article> p = (Page<Article>) list;
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
