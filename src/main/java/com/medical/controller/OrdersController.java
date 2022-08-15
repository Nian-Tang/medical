package com.medical.controller;


import com.medical.entity.Orderitme;
import com.medical.entity.Orders;
import com.medical.entity.User;
import com.medical.service.OrderitmeService;
import com.medical.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    OrdersService ordersService;
    @Autowired
    OrderitmeService orderitmeService;



    /**
     * 杨俊武
     * 查询订单接口
     * @param session
     * @return
     */
    @GetMapping("selectOrders")
    public List<Orders> selectOrders(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        List orderitmes=new ArrayList<>();
        List<Orders> orders = ordersService.selectOrders(id);
        for (Orders order : orders) {
            int orderId = order.getId();
            int[] i = new int[1024];
            for (int i1=0 ;i1<i.length; i1++) {
                if (orderId==i[i1]){
                    break;
                }
                if(i[i1]==0){
                  orderitmes.add(orderitmeService.selectOrderItme(i[i1]));
                  i[i1]=orderId;
                  break;
                }

            }


        }
        return orderitmes;
    }
}
