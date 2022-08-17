package com.medical.service;

import com.medical.entity.Munity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 社区 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface MunityService extends IService<Munity> {

    boolean updateShelves(Munity munity);

    Munity byMunity(Integer id);
}
