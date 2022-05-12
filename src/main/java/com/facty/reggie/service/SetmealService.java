package com.facty.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.facty.reggie.dto.SetmealDto;
import com.facty.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author facty
 * @create 2022-18-18 19:18
 */
public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
    public void removeWithDish(List<Long> ids);
}
