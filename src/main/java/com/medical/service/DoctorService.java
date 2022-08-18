package com.medical.service;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 医生信息 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DoctorService extends IService<Doctor> {
    //查询医生
    List<Doctor> likeDoAndDH();
}
