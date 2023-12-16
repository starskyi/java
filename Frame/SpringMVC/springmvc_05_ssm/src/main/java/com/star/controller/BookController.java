package com.star.controller;

import com.star.domain.Book;
import com.star.exception.BusinessException;
import com.star.exception.SystemException;
import com.star.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag;
        try{
            flag = bookService.add(book);
        }catch(Exception e){
            throw new SystemException("网络异常，请稍后再试", e, Code.SYSTEM_ERR);
        }

        String msg = flag ? "添加成功" : "添加失败";
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, null, msg);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.delete(id);
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, null, msg);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        if(id <= 0){
            throw new BusinessException("警告，非法操作", Code.BUSINESS_ERR);
        }
        Book book = bookService.findById(id);
        String msg = book == null ? "查询失败，请重试" : "";
        return new Result(book == null ? Code.GET_OK : Code.GET_ERR, book, msg);
    }

    @GetMapping
    public Result getAll(){
        List<Book> books = bookService.findAll();
        String msg = books == null ? "查询失败，请重试" : "";
        return new Result(books == null ? Code.GET_OK : Code.GET_ERR, books, msg);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.update(book);
        String msg = flag ? "更新成功" : "更新失败";
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }
}
