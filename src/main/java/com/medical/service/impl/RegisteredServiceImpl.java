package com.medical.service.impl;

import com.medical.entity.Registered;
import com.medical.entity.TimInoculation;
import com.medical.mapper.RegisteredMapper;
import com.medical.service.RegisteredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

    @Override
    public Registered getRegisteredById(Serializable id) {

        return getBaseMapper().getRegisteredById(id);
    }

}
