package com.medical.service;

import com.medical.entity.Registered;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 预约挂号 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface RegisteredService extends IService<Registered> {
    List<Registered> selRegistered(Integer uid);
}
