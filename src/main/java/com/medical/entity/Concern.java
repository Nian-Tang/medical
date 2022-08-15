package com.medical.entity;

    import java.io.Serializable;
    import java.util.List;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 关注
    * </p>
*
* @author GongHaiBo
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Concern implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户id
            */
    private Integer uid;

            /**
            * 被关注用户id
            */
    private Integer uiid;


//    private List<User> users;
}
