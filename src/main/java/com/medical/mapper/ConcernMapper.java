package com.medical.mapper;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 关注 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface ConcernMapper extends BaseMapper<Concern> {
    List<User> selectConcern(@Param("uid")Integer uid);
}
