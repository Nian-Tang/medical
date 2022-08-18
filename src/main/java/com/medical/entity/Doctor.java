package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 医生信息
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
            /**
            * 医生录入时间
            */
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private LocalDateTime entryDate;

            /**
            * 职称
            */
    private String title;

            /**
            * 医生简介
            */
    private String brief;

            /**
            * 医生评分
            */
    private Float point;

            /**
            * 科室编号
            */
    private Department department;

            /**
            * 医院id
            */
    private Hospital hospital;

            /**
            * 医龄
            */
    private String hoursPractice;

            /**
            * 擅长
            */
    private String excel;

            /**
            * 问诊价格
            */
    private Float consultPrice;


}
