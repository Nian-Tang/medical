package com.medical.entity;

    import java.beans.Transient;
    import java.io.Serializable;
    import java.util.List;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.mysql.cj.x.protobuf.MysqlxCrud;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 订单项
    * </p>
*
* @author JiaJieTang
* @since 2022-08-11
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Orderitme implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;

            /**
            * 药品id
            */
    private Integer drid;

            /**
            * 用户id
            */
    private Integer uid;

            /**
            * 购买数量
            */
    private Integer number;

            /**
            * 订单id
            */
    private Integer oid;

    @TableField(exist = false)
    private Orders orders;
    @TableField(exist = false)
    private Drug drug;

}
