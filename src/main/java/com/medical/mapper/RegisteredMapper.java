package com.medical.mapper;

import com.medical.entity.Registered;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 预约挂号 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface RegisteredMapper extends BaseMapper<Registered> {
    List<Registered> selRegistered(@Param("uid")Integer uid);
}
