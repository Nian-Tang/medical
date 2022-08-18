package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Munity;
import com.medical.mapper.MunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 社区 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */

@RestController
@RequestMapping("/medical/munity")
public class MunityController {
    @Autowired
    MunityMapper  munityMapper;


    @GetMapping("/munitiesSelect")
    public Object munitiesSelect(){
        QueryWrapper queryWrapper = new QueryWrapper();
        int munities = Math.toIntExact(munityMapper.selectCount(queryWrapper));
        return munities;
    }

}
