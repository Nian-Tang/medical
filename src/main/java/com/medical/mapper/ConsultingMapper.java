package com.medical.mapper;

import com.medical.entity.Consulting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 咨询表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface ConsultingMapper extends BaseMapper<Consulting> {
    List selectConsulting(@Param("uid") int uid);
}
