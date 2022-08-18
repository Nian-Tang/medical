package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Doctor;
import com.medical.mapper.DoctorMapper;
import com.medical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 医生信息 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/doctor")
public class DoctorController {

    @Autowired
    DoctorMapper doctorMapper;


    @GetMapping("/doctorSelect")
    public List<Doctor> doctorSelect(@RequestParam Integer id){
        QueryWrapper queryWrapper =  new QueryWrapper();
        queryWrapper.eq("id",id);
        List<Doctor> doctors = doctorMapper.selectList(queryWrapper);
        return doctors;
    }
}
