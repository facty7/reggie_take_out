package com.facty.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facty.reggie.entity.DishFlavor;
import com.facty.reggie.mapper.DishFlavorMapper;
import com.facty.reggie.mapper.DishMapper;
import com.facty.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author facty
 * @create 2022-35-19 14:35
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
