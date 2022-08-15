package com.medical.controller;


import com.medical.entity.TimInoculation;
import com.medical.entity.User;
import com.medical.mapper.TimInoculationMapper;
import com.medical.service.TimInoculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/medical/timinoculation")
public class TimInoculationController {
    @Autowired
    TimInoculationMapper timInoculationMapper;
    //我预约的疫苗 lyb
    @GetMapping("/selectTiminoculation")
    public TimInoculation byid(@RequestParam User user){
        return timInoculationMapper.selectTimInoculation(user.getId());
    }
}
