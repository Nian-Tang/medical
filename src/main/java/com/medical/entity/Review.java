package com.medical.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private User user;

    private String review;

    private LocalDateTime reviewDate;

    /**
     * 社区id
     */
    private Munity munity;

    /**
     * 药品id
     */
    /**
     * 数据库为varchar类型
     * 改为int类型
     */
    private Drug drug;


}
