package com.medical.service.impl;

import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUser(User user) {
        return userMapper.getUser(user);
    }
    @Override
    public List<User> getdoctor(User user){return userMapper.getdoctor(user);}
}
