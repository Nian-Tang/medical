package com.medical.service.impl;

import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired OrdersMapper ordersMapper;

    //订单查询
    @Override
    public List<Orders> allOrders() {
        return ordersMapper.allOrders();
    }
    //修改订单状态
    @Override
    public boolean updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders);
    }

}
