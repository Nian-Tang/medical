package com.medical.service;

import com.medical.entity.Consulting;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 咨询表 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ConsultingService extends IService<Consulting> {
    List<Consulting> selectUserJoinConsultingMapper(Integer uid);
}
