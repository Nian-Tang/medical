package com.medical.mapper;

import com.medical.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 医生信息 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Repository
public interface DoctorMapper extends BaseMapper<Doctor> {
    //查询医生
    List<Doctor> likeDoAndDH();
}
