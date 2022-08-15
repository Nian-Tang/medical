package com.medical.mapper;

import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface UserMapper extends BaseMapper<User> {

//    @Select("select harvest_address from user where id = #{id}")
//    public User get(int id);

    List<User> getUser(int id);


    int add(User user);


    int update(User user);

//    int delete(User user);

    int upuser(User user);
}
