package com.facty.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facty.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author facty
 * @create 2022-14-18 19:14
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
