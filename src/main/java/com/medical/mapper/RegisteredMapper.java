package com.medical.mapper;

import com.medical.entity.Registered;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.TimInoculation;

import javax.rmi.CORBA.ClassDesc;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预约挂号 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface RegisteredMapper extends BaseMapper<Registered> {

    Registered getRegisteredById(Serializable id);

}
