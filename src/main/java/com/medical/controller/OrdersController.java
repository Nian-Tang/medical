package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Orders;
import com.medical.mapper.OrdersMapper;
import com.medical.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/orders")
public class OrdersController {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrdersService ordersService;

    @GetMapping("/userOrder")
//    public List<Orders> allOrders(Orders orders){
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id",orders.getUid());
//        List<Orders> o = ordersMapper.selectList(queryWrapper);
//        return o;
//    }
      public List<Orders> allOrders(){
         return ordersService.allOrders();

    }

    }
