package com.medical.controller;


import com.medical.entity.TimInoculation;
import com.medical.entity.User;
import com.medical.entity.Vaccine;
import com.medical.mapper.TimInoculationMapper;
import com.medical.service.TimInoculationService;
import com.medical.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 预约疫苗 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/tim-inoculation")
public class TimInoculationController {
    @Autowired
    TimInoculationMapper timInoculationMapper;
    @Autowired
    TimInoculationService timInoculationService;
    @Autowired
    VaccineService vaccineService;

    /**
     * 查询我预约的疫苗 李沅斌
     */
    @GetMapping("/selectTiminoculation")
    public TimInoculation byid(User user){
        return timInoculationMapper.selectTimInoculation(user.getId());
    }


    @PostMapping("addTimInoculation/{uid}")
    public Object addTimInoculation(@RequestBody TimInoculation timInoculation, @PathVariable int uid){
        timInoculation.setTime(LocalDateTime.now());
        //查询历史接种时间
        List<TimInoculation> timInoculations=timInoculationService.whetherVaccine(uid);
        if (!timInoculations.isEmpty()){
            Duration time= Duration.between(timInoculations.get(timInoculations.size()-1).getTime(),LocalDateTime.now());
            long day= time.toDays();
            if (day<60) return -1;
        }

        //通过疫苗名称查询疫苗信息

        //查询疫苗库存
        Vaccine vaccine=timInoculationService.byVaccineName(timInoculation.getName());
        if (vaccine.getNumber()<1)return -1;

        timInoculation.setVid(vaccine.getId());
        //通过医院名称查询医院的id
        TimInoculation hospitals= timInoculationService.byId(timInoculation.getHName());
        timInoculation.setHid(hospitals.getHospital().getId());
        timInoculation.setUid(uid);
        boolean value=timInoculationService.addTimInoculation(timInoculation);
        if (value){
            vaccine.setNumber(vaccine.getNumber()-1);
            //更新库存
            vaccineService.updateNum(vaccine);
            return 1;
        }
        else return -1;
    }

}
