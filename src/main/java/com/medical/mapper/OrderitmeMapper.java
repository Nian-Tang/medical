package com.medical.mapper;

import com.medical.entity.Orderitme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单项 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface OrderitmeMapper extends BaseMapper<Orderitme> {
List<Orderitme> selectOrderItme();
List<Orderitme> select(@Param("uid") int uid);
}
