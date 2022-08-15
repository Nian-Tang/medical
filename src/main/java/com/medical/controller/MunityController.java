package com.medical.controller;


import com.medical.entity.Munity;
import com.medical.service.MunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    MunityService munityService;




    @GetMapping("selectUserJoinMunity")
    public Munity selectUserJoinMunity() {
        Munity munity = munityService.selectUserJoinMunityssss();
        return munity;

    }
}
