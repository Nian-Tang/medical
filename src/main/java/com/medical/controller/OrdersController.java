package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */
@RestController
@RequestMapping("/medical/orders")
public class OrdersController {


    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrdersService ordersService;


    @GetMapping("/Order")
    public List<Orders> allOrders() {
        List<Orders> orders = ordersMapper.allOrders();
        return orders;
    }

    @PutMapping("/updateOrders")
    public boolean updateOrders(@RequestBody Orders orders){
        UpdateWrapper<Orders> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",orders.getId()).set("order_state",orders.getOrderState());
        boolean update = ordersService.update(updateWrapper);
        return update;

    }

}
