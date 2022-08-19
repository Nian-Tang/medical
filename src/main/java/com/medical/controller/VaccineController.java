package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Hospital;
import com.medical.entity.Vaccine;
import com.medical.entity.Warehouse;
import com.medical.mapper.VaccineMapper;
import com.medical.mapper.WarehouseMapper;
import com.medical.service.HospitalService;
import com.medical.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 疫苗信息 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/vaccine")
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @Autowired
    HospitalService hospitalService;
    @Autowired
    WarehouseMapper warehouseMapper;
    @Autowired
    VaccineMapper vaccineMapper;


    /**
     * 查询医院
     * @return
     */
    @GetMapping("/selectHospital")
    public Map<String,Object> selectHospital(){
        List<Hospital> list = hospitalService.list();
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("data",list);
        return map;
    }

    /**
     * 查询选中医院所有仓库
     * @param hid
     * @return
     */
    @GetMapping("/selectVaccine")
    public Map<String,Object> selectVaccine(int hid){
        QueryWrapper<Warehouse> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("hid",hid);
        Warehouse warehouse = warehouseMapper.selectOne(queryWrapper1);
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("data",warehouse);
        return map;
    }

    /**
     * 为该仓库添加疫苗
     * @param vaccine
     * @param wid
     * @return
     */
    @PutMapping("/newVaccine")
    public Map<String,Object> newVaccine(@RequestBody Vaccine vaccine,int wid){
        vaccine.setWid(wid);
        boolean va= vaccineService.save(vaccine);
        Map<String,Object> map=new HashMap<>();
        if(va){
            map.put("code","200");
            map.put("msg","添加成功");
            map.put("data",va);
            return map;
        }else {
            map.put("code","500");
            map.put("msg","添加失败");
            map.put("data",va);
            return map;
        }
    }
}
