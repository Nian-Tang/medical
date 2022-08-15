package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 药品
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int id;

    /**
     * 药品名称
     */
    private String dName;

    /**
     * 描述
     */
    private String describe;

    /**
     * 功能
     */
    private String function;

    /**
     * 规格
     */
    private String specification;

    /**
     * 性状
     */
    private String character;

    /**
     * 用法
     */
    private String usage;

    /**
     * 成分
     */
    private String ingredient;

    /**
     * 禁忌
     */
    private String taboo;

    /**
     * 库存;
     */
    private Integer stock;

    /**
     * 分类id
     */
    private Integer cid;


}
