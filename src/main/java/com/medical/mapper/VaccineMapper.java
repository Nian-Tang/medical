package com.medical.mapper;

import com.medical.entity.Vaccine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 疫苗信息 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface VaccineMapper extends BaseMapper<Vaccine> {

    boolean updateNum(@Param("pram")Vaccine vaccine);
}
