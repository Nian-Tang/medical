package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Vaccine;
import com.medical.mapper.VaccineMapper;
import com.medical.service.impl.VaccineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    VaccineServiceImpl vaccineServiceImpl;
    @Autowired
    VaccineMapper vaccineMapper;


    //疫苗查询
    @GetMapping("/allVaccine")
    public Object allVaccine(@RequestParam int wid){
        QueryWrapper<Vaccine> vaccineQueryWrapper = new QueryWrapper<>();
        vaccineQueryWrapper.eq("wid",wid);
        Page<Vaccine> vaccinePage = (Page<Vaccine>) vaccineMapper.selectPage(new Page<>(0,6),vaccineQueryWrapper);
        return vaccinePage;
    }

    @PostMapping("/insertVaccine")
    public Object insertVaccine(@RequestBody Vaccine vaccine){
        boolean save = vaccineServiceImpl.save(vaccine);
        return save;
    }

    @DeleteMapping("/deleteVaccine")
    public Object deleteVaccine(int id){
        QueryWrapper<Vaccine> vaccineQueryWrapper = new QueryWrapper<>();
        vaccineQueryWrapper.eq("id",id);
        boolean remove = vaccineServiceImpl.remove(vaccineQueryWrapper);
        return remove;
    }

    @PutMapping("/updateVaccine")
    public Object updateVaccine(@RequestBody Vaccine vaccine){
        vaccineServiceImpl.updateById(vaccine);
        return vaccine;
    }
}
