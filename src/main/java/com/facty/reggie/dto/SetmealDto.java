package com.facty.reggie.dto;

import com.facty.reggie.entity.Setmeal;
import com.facty.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
