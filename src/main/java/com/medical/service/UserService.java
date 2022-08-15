package com.medical.service;

import com.medical.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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
     * 修改密码
     * @param
     * @return
     */
    String updatePasswordByUsername(@Param("username")String username, @Param("password") String password,@Param("newPassword") String newPassword);

    /**
     * 根据用户名查询信息
     * @param username
     * @return
     */
    User getUsername(@Param("username") String username);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserId(@Param("id") int id);

}
