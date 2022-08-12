package com.medical.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author GongHaiBo
 * @since 2022-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
