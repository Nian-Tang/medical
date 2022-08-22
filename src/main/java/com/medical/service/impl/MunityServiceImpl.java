package com.medical.service.impl;

import com.medical.entity.Munity;
import com.medical.mapper.MunityMapper;
import com.medical.service.MunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 社区 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class MunityServiceImpl extends ServiceImpl<MunityMapper, Munity> implements MunityService {
    @Autowired
    MunityMapper munityMapper;
    @Override
    public boolean updateShelves(Munity munity) {
        return munityMapper.updateShelves(munity)>0;
    }

    @Override
    public Munity byMunity(Integer id) {
        return munityMapper.byMunity(id);
    }
}
