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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询用户疫苗接种情况 李豪
     * @param id
     * @return
     */
    @GetMapping("/gettim")
    public Map<String,Object> get(int id){
        List<TimInoculation> getTimInoculation= timInoculationService.gettim(id);
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("data",getTimInoculation);
        return map;
    }
    /**
     * 预约疫苗 返回给用户看 自己的用户名 创建订单的时间 状态是否接种完成  王瑞
     * 新增数据库 预约疫苗表的状态
     * @param timInoculation
     * @param uid
     * @return
     */
    @PostMapping("addTimInoculation/{uid}")
    public Object addTimInoculation(@RequestBody TimInoculation timInoculation, @PathVariable int uid){
        if (timInoculation.getMoney()==0)return "请先支付";
        timInoculation.setTime(LocalDateTime.now());
        //查询历史接种时间
        List<TimInoculation> timInoculations=timInoculationService.whetherVaccine(uid,timInoculation.getName());
        if (!timInoculations.isEmpty()){
            Duration time= Duration.between(timInoculations.get(timInoculations.size()-1).getTime(),LocalDateTime.now());
            long day= time.toDays();
            if (day<60) return -1;
        }
        //通过疫苗名称查询疫苗信息
        Vaccine vaccine=timInoculationService.byVaccineName(timInoculation.getName());
        if (vaccine.getNumber()<1)return -1;
        timInoculation.setVid(vaccine.getId());
        //通过医院名称查询医院的id
        TimInoculation hospitals= timInoculationService.byId(timInoculation.getHName());
        timInoculation.setHid(hospitals.getHospital().getId());
        timInoculation.setUid(uid);
        timInoculation.setTimState("待接种");
        //创建预约疫苗
        int value=timInoculationService.addTimInoculation(timInoculation);
        if (value!=0){
            vaccine.setNumber(vaccine.getNumber()-1);
            //更新库存
            vaccineService.updateNum(vaccine);
            return timInoculationService.byTimInoculation(timInoculation.getId());
        }
        else return -1;
    }
}
