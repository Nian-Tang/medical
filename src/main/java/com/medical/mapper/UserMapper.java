package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根究用户名修改密码
     * @param username
     * @param password
     * @return
     */
    Integer updatePasswordByUsername(@Param("username")String username, @Param("password") String password);

    /**
     * 根究用户名查询所有信息
     * @param username
     * @return
     */
    User getUsername(@Param("username") String username);

}

