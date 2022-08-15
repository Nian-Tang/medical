package com.medical.mapper;

import com.medical.entity.Consulting;
import com.medical.entity.Orderitme;
import com.medical.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Zhangpan
 * @since 2022-08-11
 */
public interface UserMapper extends BaseMapper<User> {
     List<Consulting> selectUser(User user);

}
