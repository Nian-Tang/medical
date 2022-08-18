package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**

 * <p>
 * 药品分类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private int id;

    /**
     * 类别
     */
    private String classes;


}
