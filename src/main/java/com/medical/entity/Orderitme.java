package com.medical.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orderitme implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;
    /**
     * 药品id
     */
    Integer drid;

    @TableField(exist = false)
    private Drug drug;

    /**
     * 用户id
     */
    Integer uid;

    @TableField
    private User user;
    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 订单id
     */
    private Integer oid;

    @TableField(exist = false)
    private Orders orders;





}
