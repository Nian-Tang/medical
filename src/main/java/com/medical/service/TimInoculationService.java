package com.medical.service;

import com.medical.entity.TimInoculation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.Vaccine;

import java.util.List;

/**
 * <p>
 * 预约疫苗 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface TimInoculationService extends IService<TimInoculation> {
    Vaccine byVaccineName(String name);

    List<TimInoculation> whetherVaccine(Integer id);

    int addTimInoculation(TimInoculation timInoculation);

    TimInoculation byId(String hName);

    List<TimInoculation> gettim(int id);

    TimInoculation byTimInoculation(Integer id);
}
