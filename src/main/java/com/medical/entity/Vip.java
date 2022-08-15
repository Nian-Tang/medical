package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 会员表
    * </p>
*
* @author JiaJieTang
* @since 2022-08-15
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Vip implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 注册时间
            */
    private LocalDateTime registerDate;

            /**
            * 会员到期时间
            */
    private LocalDateTime expireDate;


}
