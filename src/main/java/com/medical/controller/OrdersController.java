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
        List orderitmes = new ArrayList<>();
        List<Orders> orders = ordersService.selectOrders(id);
        for (Orders order : orders) {
            int orderId = order.getId();
            List<Orderitme> select = orderitmeService.select(orderId);
            for (Orderitme orderitme : select) {
                orderitmes.add(orderitme);
            }
        }
        return orderitmes;
    }

    /**
     *查询不同月份的营业额
     * @return
     */
    @GetMapping("queryAmountByTimePeriod")
    public double[] queryAmountByTimePeriod() {
        List<Orderitme> orderitmes = new ArrayList<>();
        List<Orders> orders = ordersService.QueryAmountByTimePeriod();
        //j储存的是’年份/月份‘
        String[] j = new String[1024];
        for (Orders order : orders) {
            int month = order.getOrderDatetime().getMonth();
            int year = order.getOrderDatetime().getYear();
            for (int j1 = 0; j1 < j.length; j1++) {
                String ym = year + "/" + month;
                if (j[j1] == null) {
                    j[j1] = ym;
                    break;
                } else if (j[j1].equals(ym)) {
                    break;
                }
            }
        }
        selectOI(orderitmes);
        int monthlySalesLength = 0;
        for (int j1 = 0; j1 < j.length; j1++) {
            if (j[j1] == null) {
                monthlySalesLength = j1;
                break;
            }
        }
        //monthlySales 储存的是营业额
        double monthlySales[] = new double[monthlySalesLength];
        for (Orderitme orderitme : orderitmes) {
            int month = orderitme.getOrders().getOrderDatetime().getMonth();
            int year = orderitme.getOrders().getOrderDatetime().getYear();
            System.out.println(orderitme);
            for (int j1 = 0; j1 < j.length & j[j1] != null; j1++) {
                String s = year + "/" + month;
                if (s.equals(j[j1])) {
                    double v = orderitme.getNumber() * orderitme.getDrug().getPrice();
                    monthlySales[j1] += v;
                }
            }
        }

        return monthlySales;
    }


    private void selectOI(List<Orderitme> orderitmes) {
        List<Orderitme> orderitmes1 = orderitmeService.selectOrderItme();
        for (Orderitme orderitme : orderitmes1) {
            orderitmes.add(orderitme);
        }
    }




}
