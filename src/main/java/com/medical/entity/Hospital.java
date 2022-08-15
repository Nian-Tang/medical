package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 医院
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 医院名称
     */
    private String hName;

    /**
     * 地址
     */
    private String address;

    /**
     * 医院联系电话
     */
    private Integer hTel;

    /**
     * 医院信息
     */
    private String information;


}
