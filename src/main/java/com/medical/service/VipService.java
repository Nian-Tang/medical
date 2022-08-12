package com.medical.service;

import com.medical.entity.Vip;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
public interface VipService extends IService<Vip> {

    public boolean updateTime(Integer num,Integer id);
}
