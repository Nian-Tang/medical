package com.medical.mapper;

import com.medical.entity.TimInoculation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.Vaccine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 预约疫苗 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface TimInoculationMapper extends BaseMapper<TimInoculation> {

    List<TimInoculation> selectTimInoculation(Integer id);

    Vaccine byVaccineName(String name);

    List<TimInoculation> whetherVaccine(Integer id,String name);

    int addTimInoculation(@Param("timInoculation") TimInoculation timInoculation);

    TimInoculation byId(String hName);

    List<TimInoculation> gettim(int id);

    TimInoculation byTimInoculation(Integer id);
}
