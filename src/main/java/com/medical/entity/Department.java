package com.medical.entity;

    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 科室
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

            /**
            * 科室名称
            */
    private String dName;

            /**
            * 录入时间
            */
        @TableField("Entry_date")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    private LocalDateTime entryDate;

            /**
            * 医院外键
            */
    private Integer hid;


}
