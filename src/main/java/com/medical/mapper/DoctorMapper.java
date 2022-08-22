package com.medical.mapper;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 医生信息 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DoctorMapper extends BaseMapper<Doctor> {
   int adddo(Doctor doctor);
}
