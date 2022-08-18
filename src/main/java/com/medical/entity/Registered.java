package com.medical.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import sun.dc.pr.PRError;

/**
 * <p>
 * 预约挂号
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Registered implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    private Integer uid;

    /**
     * 医院id
     */
    private Integer hid;

    /**
     * 科室id
     */
    private Integer did;

    /**
     * 预约时间
     */
    private LocalDateTime appointment;

    /**
     * 预约单号
     */
    private String reservationNo;

    private List<User> users;
    private List<Hospital> hospitals;
    private List<Department> departments;


}
