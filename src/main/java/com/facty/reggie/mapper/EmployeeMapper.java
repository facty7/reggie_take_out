package com.facty.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facty.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author facty
 * @create 2022-06-15 17:06
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
