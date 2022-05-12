package com.facty.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facty.reggie.common.R;
import com.facty.reggie.entity.Category;
import com.facty.reggie.entity.Employee;
import com.facty.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author facty
 * @create 2022-28-18 17:28
 */
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 菜品分类添加
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("新增分类名称：{}",category.toString());

        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        //构造分页构造器
        Page<Category> pageInfo = new Page<>(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();

        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort);

        //执行查询
        categoryService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }


    /**
     * 根据id删除分类
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(long ids){
        log.info("删除分类id为：{}",ids);
//        categoryService.removeById(ids);
        categoryService.remove(ids);
        return R.success("分类信息删除成功");
    }

    /**
     * 修改菜品分类信息
     * @param
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info(category.toString());


        categoryService.updateById(category);

        return R.success("分类信息修改成功");
    }

    /**
     * 根据分类查询
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null,Category::getType,category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);


    }

}
