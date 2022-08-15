package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public interface UserService extends IService<User> {

    List<User> findCases(int id);

    double add(User user);

    double update(User user);

    double upuser(User user);

    List<User> getUser(int id);

    List<User> byCases(Integer id);
}
