package com.medical.service.impl;

import com.medical.entity.Registered;
import com.medical.mapper.RegisteredMapper;
import com.medical.mapper.UserMapper;
import com.medical.service.RegisteredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 预约挂号 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class RegisteredServiceImpl extends ServiceImpl<RegisteredMapper, Registered> implements RegisteredService {

    @Autowired
    RegisteredMapper registeredMapper;


    @Override
    public Registered getReg(int uid) {
        return registeredMapper.getReg(uid);
    }
}
