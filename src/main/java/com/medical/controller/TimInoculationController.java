package com.medical.controller;


import com.alibaba.fastjson.JSON;
import com.medical.service.TimInoculationService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

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
    TimInoculationService timInoculationService;
    @RequestMapping("getTimInoculationById/{id}")
    public String getTimInoculationById(@PathParam("id")Integer id){
        return JSON.toJSONString(timInoculationService.getTimInoculationById(id));
    }


}
