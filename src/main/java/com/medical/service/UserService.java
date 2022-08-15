package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

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

    /**
     * 查询用户全表以及医生外键
     */
    List<User> getUser(User user);
    /**
     * 通过用户表中的医生外键查询对应医生表
     */
    List<User> getdoctor(User user);
}
