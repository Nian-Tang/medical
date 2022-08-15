package com.medical.mapper;

import com.medical.entity.Consulting;
import com.medical.entity.Orderitme;
import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Zhangpan
 * @since 2022-08-11
 */
public interface UserMapper extends BaseMapper<User> {

     List<User> findCases(int id);

     List<User> byCases(int id);

     List<Consulting> selectUser(User user);

    List<User> getUser(int id);

    int add(User user);

    int update(User user);

    int upuser(User user);

}
