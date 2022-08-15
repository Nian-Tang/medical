package com.medical.mapper;

import com.medical.entity.Orderitme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;

import java.util.List;

/**
 * <p>
 * 订单项 Mapper 接口
 * </p>
 *
 * @author ZhangPan
 * @since 2022-08-11
 */
public interface OrderitmeMapper extends BaseMapper<Orderitme>{
    List<Orderitme> selectOrderByUser(User user);
}
