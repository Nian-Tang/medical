package com.medical.service.impl;

import com.medical.entity.TimInoculation;
import com.medical.entity.Vaccine;
import com.medical.mapper.TimInoculationMapper;
import com.medical.service.TimInoculationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    TimInoculationMapper timInoculationMapper;
    @Override
    public Vaccine byVaccineName(String name) {
        return timInoculationMapper.byVaccineName(name);
    }

    @Override
    public List<TimInoculation> whetherVaccine(Integer id) {
        return timInoculationMapper.whetherVaccine(id);
    }

    @Override
    public boolean addTimInoculation(TimInoculation timInoculation) {
        return timInoculationMapper.addTimInoculation(timInoculation)>0;
    }

    @Override
    public TimInoculation byId(String hName) {
        return timInoculationMapper.byId(hName);
    }
}
