package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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

    private Integer id;

    private User user;

    /**
     * 订单状态
     */
    private String orderState;

    /**
     * 订单编号
     */
    private Integer orderNumber;


    /**
     * 创建订单时间
     */
    private Date orderDatetime;

}
