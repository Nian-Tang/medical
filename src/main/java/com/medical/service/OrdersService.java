package com.medical.service;

import com.medical.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface OrdersService extends IService<Orders> {
    List<Orders> selectOrders(int uid);

}
