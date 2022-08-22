package com.medical.mapper;

import com.medical.entity.Consulting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 咨询表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ConsultingMapper extends BaseMapper<Consulting> {

    List<Consulting> selectDoctorUser(Integer doid);
}
