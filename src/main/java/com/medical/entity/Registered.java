package com.medical.entity;

    import java.beans.Transient;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.List;

    import com.baomidou.mybatisplus.annotation.TableField;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

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

    private Integer id;

            /**
            * 用户id
            */
    private Integer uid;

            /**
            * 医院id
            */
    private Hospital hospital;

            /**
            * 科室id
            */
    private Department department;

            /**
            * 预约时间
            */
    private LocalDateTime appointment;

            /**
            * 预约单号
            */
    private String reservationNo;

//    @TableField(exist = false)
//    private Hospital hospital;
//
//    @TableField(exist = false)
//    private Department department;


}
