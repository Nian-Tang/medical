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
    private UserMapper userMapper;

//    @Override
//    public User get(int id) {
//        return userMapper.get(id);
//    }


    @Override
    public double add(User user) {
        return userMapper.add(user);
    }


//    @Override
//    public boolean delete(User user) {
//
//        return userMapper.delete(user)>0;
//    }

    @Override
    public double update(User user) {
        return userMapper.update(user);
    }

    @Override
    public double upuser(User user) {
        return userMapper.upuser(user);
    }

    @Override
    public List<User> getUser(int id) {
        return userMapper.getUser(id);
    }


}
