package com.facty.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facty.reggie.entity.User;
import com.facty.reggie.mapper.UserMapper;
import com.facty.reggie.mapper.UserMapper;
import com.facty.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
