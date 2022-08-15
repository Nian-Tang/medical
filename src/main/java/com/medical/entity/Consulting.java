package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

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

    private int id;

            /**
            * 创建时间
            */
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
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

    public String getDescribe() {
        return describe;
    }
}
