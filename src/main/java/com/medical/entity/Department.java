package com.medical.entity;

    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
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

            /**
            * 科室名称
            */
    private String dName;

            /**
            * 录入时间
            */
        @TableField("Entry_date")
    private LocalDateTime entryDate;

            /**
            * 医院外键
            */
    private Integer hid;


}
