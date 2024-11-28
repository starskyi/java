package com.star.controller;

import com.star.pojo.Category;
import com.star.pojo.Result;
import com.star.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //添加分类
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    //获取分类
    @GetMapping
    public Result<List<Category>> list() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    //获取分类详细
    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam Integer id) {
        Category category = categoryService.findById(id);
        return Result.success(category);
    }

    //修改分类
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    //删除分类
    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return Result.success();
    }
}
