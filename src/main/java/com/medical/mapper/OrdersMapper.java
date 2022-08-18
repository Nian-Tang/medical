package com.medical.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.Orders;
import com.medical.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    //后端
    List<Orders> allOrders();
    //修改订单状态
    boolean updateOrders(Orders orders);



}
