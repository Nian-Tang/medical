package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 预约疫苗
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TimInoculation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 预约时间;
            *///王瑞
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    private LocalDateTime time;

            /**
            * 疫苗id
            */
    private Integer vid;

            /**
            * 用户id
            */
    private Integer uid;

            /**
            * 医院id
            */
    private Integer hid;

    //疫苗名称
    public String name;
    //医院名称
    public String hName;

    private User user;

    private Vaccine vaccine;

    private Hospital hospital;


}
