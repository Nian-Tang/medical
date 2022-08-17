package com.medical.service.impl;

import com.medical.entity.TimInoculation;
import com.medical.mapper.TimInoculationMapper;
import com.medical.service.TimInoculationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 预约疫苗 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class TimInoculationServiceImpl extends ServiceImpl<TimInoculationMapper, TimInoculation> implements TimInoculationService {

    @Override
    public TimInoculation getTimInoculationById(Serializable id) {
         getBaseMapper().getTimInoculationById(id);
         System.out.println("阿表哥我又来了哦！");
         return null;
    }
}
