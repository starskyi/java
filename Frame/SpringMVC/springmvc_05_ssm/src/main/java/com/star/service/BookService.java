package com.star.service;

import com.star.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /**
     * 添加
     * @param book book
     * @return 0/1
     */
    boolean add(Book book);

    /**
     * 根据id删除
     * @param id book id
     * @return 0/1
     */
    boolean delete(int id);

    /**
     * 根据id查询
     * @param id book id
     * @return book
     */
    Book findById(int id);

    /**
     * 查询所用
     * @return 所有内容
     */
    List<Book> findAll();

    /**
     * 更新
     * @param book 更新的内容
     * @return 更新的数量
     */
    boolean update(Book book);

}
