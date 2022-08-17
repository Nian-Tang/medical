package com.medical.entity;


import java.io.Serializable;

import com.medical.service.OrdersService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;
    private Integer uid;

    /**
     * 订单状态
     */
    private String orderState;

    /**
     * 订单编号
     */
    private Integer orderNumber;

    public String getOrderState() {
        if (null != orderState)
            return orderState;
        String desc = "未知";
        switch (orderState) {
            case OrdersService.waitPay:
                desc = "待付";
                break;
            case OrdersService.waitDelivery:
                desc = "待发";
                break;
            case OrdersService.waitConfirm:
                desc = "待收";
                break;
            case OrdersService.waitReview:
                desc = "等评";
                break;
            case OrdersService.finish:
                desc = "完成";
                break;
            case OrdersService.delete:
                desc = "刪除";
                break;
            case OrdersService.backPay:
                desc = "退款";
                break;
            default:
                desc = "未知";
        }
        orderState = desc;
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

}
