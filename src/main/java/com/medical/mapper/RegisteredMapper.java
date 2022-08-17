package com.medical.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Registered;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;

/**
 * <p>
 * 预约挂号 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface RegisteredMapper extends BaseMapper<Registered> {
Registered getRegisteredById(Serializable id);
}
