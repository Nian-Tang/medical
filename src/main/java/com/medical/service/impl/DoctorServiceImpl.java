package com.medical.service.impl;

import com.medical.entity.Doctor;
import com.medical.mapper.DoctorMapper;
import com.medical.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 医生信息 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    //查询医生
    @Override
    public List<Doctor> likeDoAndDH() {
        return doctorMapper.likeDoAndDH();
    }
}
