package com.facty.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.facty.reggie.entity.Category;

/**
 * @author facty
 * @create 2022-17-18 17:17
 */
public interface CategoryService extends IService<Category> {

    public void remove(long ids);

}
