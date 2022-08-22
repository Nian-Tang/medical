package com.medical.controller;


import com.medical.entity.Munity;
import com.medical.service.MunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //社区下架 王瑞
    @PutMapping("updateShelves")
    public String updateShelves(@RequestBody Munity munity){
        Munity munitys=munityService.byMunity(munity.getId());
        munitys.setCState("已下架");
        boolean bool=munityService.updateShelves(munitys);
        if (bool)return "下架成功";
        else return "下架失败";
    }

}
