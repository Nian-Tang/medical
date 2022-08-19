package com.medical.entity;

    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 疫苗信息
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Vaccine implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

            /**
            * 疫苗名称
            */
    private String vname;

            /**
            * 疫苗类型
            */
    private String vaccineType;

            /**
            * 生产日期
            */
            @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime vaccineDate;

            /**
            * 注意事项
            */
    private String preautions;

            /**
            * 数量
            */
    private Integer number;

            /**
            * 仓库id
            */
    private Integer wid;

            /**
            * 上午接种时间
            */
            @JsonFormat( pattern = "HH:mm:ss")
    private LocalTime amLnoculationDate;

            /**
            * 上午结束接种时间
            */
            @JsonFormat( pattern = "HH:mm:ss")
    private LocalTime amOverDate;

            /**
            * 下午接种时间
            */
            @JsonFormat( pattern = "HH:mm:ss")
    private LocalTime pmLnoculationDate;

            /**
            * 下午结束接种时间
            */
            @JsonFormat( pattern = "HH:mm:ss")
    private LocalTime pmOverDate;


}
