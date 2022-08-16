package com.medical.service;

import com.medical.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-11
 */

public interface OrdersService extends IService<Orders> {


//    ------------------------------------------------后端----------------------------------------------------------------//
    //订单查询
    List<Orders> allOrders();
    //修改订单状态
    boolean updateOrders(@Param("orders") Orders orders);
//    ------------------------------------------------前端----------------------------------------------------------------//


}
