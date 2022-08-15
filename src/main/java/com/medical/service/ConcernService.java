package com.medical.service;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 关注 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ConcernService extends IService<Concern> {
    List<User> selectConcern(Integer uid);
}
