package com.medical.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    *
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Vip implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private int id ;

            /**
            * 注册时间
            */
    private Date registerDate;

            /**
            * 会员到期时间
            */
    private Date expireDate;




}
