package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.fasterxml.jackson.annotation.JsonFormat;
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

    public class Registered implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

            /**
            * 用户id
            */
    private User user;

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
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private LocalDateTime appointment;

            /**
            * 预约单号
            */
    private String reservationNo;


}
