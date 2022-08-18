package com.medical.entity;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; //hhb
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 * 用户表
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;



    @TableId(value = "id", type = IdType.ASSIGN_ID)  //zdh
    private int id;

    private String username;

    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private LocalDate brithday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系方式
     */
    private Integer tel;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 注册时间
     */
    private LocalDateTime enrollDate;

    /**
     * 医生外键
     */
    private Integer doid;

    /**
     * 封号状态
     */
    private String uState;
    /**
     * 收货地址
     */
    private String harvest_address;


    private String harvestAddress;

    private Integer vipId;

}
