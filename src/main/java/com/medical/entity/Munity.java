package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 社区
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Munity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
            /**
            * 小标题
            */
    private String subtitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布日期
     */
    private LocalDateTime contentDate;

    /**
     * 发布状态
     */
    private String cState;

    /**
     * 用户id
     */
    private Integer uid;


}
