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

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserId(@Param("id") int id);


    /**
     * 根据用户uid（用户表的外键）查询用户关注的医生
     * @param uid
     * @return
     */
    List<User> getAllMyConcernDoctor(@Param("uid") int uid);

    @Select("select * from user where username = #{userName}")
    List<User> selectByUserName(String userName);
    User login(@Param("username") String username, @Param("password") String password);

}

