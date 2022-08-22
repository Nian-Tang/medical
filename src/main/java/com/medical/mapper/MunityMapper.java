package com.medical.mapper;

import com.medical.entity.Munity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 社区 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface MunityMapper extends BaseMapper<Munity> {

    @Update("UPDATE munity set subtitle=#{subtitle},content=#{content},content_date=#{contentDate},c_state=#{cState},uid=#{uid},fabulous=#{fabulous} WHERE id=#{id}")
    @Results(id = "mun",value = {
            @Result(property = "contentDate",column = "content_date"),
            @Result(property = "cState",column = "c_state")
    })
    int updateShelves(Munity munity);
    @Select("select * FROM munity where id=#{id}")
    Munity byMunity(Integer id);
}
