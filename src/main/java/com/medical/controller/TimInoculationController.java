package com.medical.controller;


import com.medical.entity.TimInoculation;
import com.medical.entity.User;
import com.medical.mapper.TimInoculationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 我预约的疫苗 lyb
     */
    @GetMapping("/selectTiminoculation")
    public TimInoculation byid(User user){
        return timInoculationMapper.selectTimInoculation(user.getId());
    }

}
