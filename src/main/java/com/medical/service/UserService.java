package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface UserService extends IService<User> {

    List<User> findCases(Integer id);

    double add(User user);

    double update(User user);

    double upuser(User user);

    List<User> getUser(Integer id);

    List<User> byCases(Integer id);

}
