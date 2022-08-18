package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Integer id=0;

            /**
            * 注册时间
            */

    private Date registerDate;

            /**
            * 会员到期时间
            */

    private Date expireDate;

    /**
     * 用户外键
     */
    private Integer uid;
}
