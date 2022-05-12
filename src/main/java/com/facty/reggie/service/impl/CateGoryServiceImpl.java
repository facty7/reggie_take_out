package com.facty.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facty.reggie.common.CustomException;
import com.facty.reggie.entity.Category;
import com.facty.reggie.entity.Dish;
import com.facty.reggie.entity.Setmeal;
import com.facty.reggie.mapper.CategoryMapper;
import com.facty.reggie.service.CategoryService;
import com.facty.reggie.service.DishService;
import com.facty.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author facty
 * @create 2022-18-18 17:18
 */
@Service
public class CateGoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(long ids) {
        //是否根菜品关联
        LambdaQueryWrapper<Dish> dishlambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishlambdaQueryWrapper.eq(Dish::getCategoryId,ids);
        int count1 = dishService.count(dishlambdaQueryWrapper);

        if(count1>0){
            //抛出异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }


        //是否跟套餐关联
        LambdaQueryWrapper<Setmeal>  setmealLambdaQueryWrapper= new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,ids);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);

        if(count2>0){
            //抛出异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除
        super.removeById(ids);

    }
}
