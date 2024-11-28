package com.star.service;

import com.star.pojo.Article;
import com.star.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    void update(Article article);

    void delete(Integer id);
}
