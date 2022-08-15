package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */
public interface UserService extends IService<User> {

    User login(User user);

}
