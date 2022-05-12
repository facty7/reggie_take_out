package com.facty.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facty.reggie.entity.Employee;
import com.facty.reggie.mapper.EmployeeMapper;
import com.facty.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author facty
 * @create 2022-09-15 17:09
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
