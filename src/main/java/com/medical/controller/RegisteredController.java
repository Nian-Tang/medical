package com.medical.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Registered;
import com.medical.mapper.RegisteredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 预约挂号 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/registered")
public class RegisteredController {

    @Autowired
    RegisteredMapper registeredMapper;

    @GetMapping("/registereds")
    public Page<Registered> registered(@RequestParam(value = "start",defaultValue = "1") int start,
                                       @RequestParam(value = "size" ,defaultValue = "10") int size){
        Page<Registered> registeredPage = registeredMapper.selectPage(new Page<>(start,size),null);
        return registeredPage;
    }

}
