package com.medical.mapper;

import com.medical.entity.Vip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-12
 */
@Mapper
public interface VipMapper extends BaseMapper<Vip> {
    //修改到期时间
    @Update("update vip set expire_date = date_add(expire_date,interval #{num} month) WHERE id= #{id}")
    int updateTime(Integer id, Integer num);

//    @Insert("INSERT INTO vip (expire_date) SELECT date_add(expire_date,interval #{num} month) FROM vip")
//    Boolean insertTime(Integer num);
}
