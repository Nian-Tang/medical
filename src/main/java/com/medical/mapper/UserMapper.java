package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

     User login(@Param("username") String username, @Param("password") String password);

}
