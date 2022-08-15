package com.medical.mapper;

import com.medical.entity.Vip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZhangPan
 * @since 2022-08-11
 */
public interface VipMapper extends BaseMapper<Vip> {


     @Update("UPDATE vip v set expire_date = DATE_ADD(expire_date, INTERVAL #{num} Day) ")
     public Boolean updateTime(Integer num);
}
