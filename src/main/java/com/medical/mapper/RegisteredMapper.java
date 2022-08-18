package com.medical.mapper;

import com.medical.entity.Registered;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 预约挂号 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Repository
public interface RegisteredMapper extends BaseMapper<Registered> {
    //查看我的预约
    Registered getReg(int uid);
}
