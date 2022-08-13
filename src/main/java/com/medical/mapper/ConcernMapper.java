package com.medical.mapper;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.Doctor;
import com.medical.entity.Munity;
import com.medical.entity.User;
import org.apache.ibatis.annotations.Mapper;

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

    List<User> concerns(int id);

    List<Munity> concernessay(int uid);
}
