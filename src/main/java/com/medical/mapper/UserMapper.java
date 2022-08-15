package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select * from user where username = #{userName}")
    List<User> selectByUserName(String userName);
    User login(@Param("username") String username, @Param("password") String password);

}
