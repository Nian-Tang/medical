package com.medical.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

    import java.util.List;



/**
 * <p>
 * 咨询表
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Consulting implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
   /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 咨询内容
     */
    private String describe;

    /**
     * 咨询状态
     */
    private String cState;

    /**
     * 解答内容
     */
    private String describle;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 医生id
     */
    private Integer doid;

    private List<User> users;

    private List<Doctor> doctors;
    

}
