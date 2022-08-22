package com.medical.service.impl;

import com.medical.entity.Vaccine;
import com.medical.mapper.VaccineMapper;
import com.medical.service.VaccineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 疫苗信息 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class VaccineServiceImpl extends ServiceImpl<VaccineMapper, Vaccine> implements VaccineService {

    @Autowired
    VaccineMapper vaccineMapper;

    @Override
    public boolean updateNum(Vaccine vaccine) {
        return vaccineMapper.updateNum(vaccine);
    }
}
