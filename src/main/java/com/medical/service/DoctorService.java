package com.medical.service;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 医生信息 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DoctorService extends IService<Doctor> {
   double adddo(Doctor doctor);
}
