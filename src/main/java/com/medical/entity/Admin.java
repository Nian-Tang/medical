package com.medical.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 管理员
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

           /**
           *  id
           */
    private int id;

           /**
           *  账户名
           */
    private String name;

            /**
            * 密码
            */
    private String password;


}
