package com.medical.controller;


import com.alibaba.fastjson.JSON;
import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.service.RegisteredService;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.rmi.CORBA.ClassDesc;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

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
    RegisteredService registeredService;

    @RequestMapping("/getRegisteredById/{id}")
    public String getRegisteredById(@PathParam("id") Integer id){
//        User user =(User) session.getAttribute("user");
//
//        registeredService.getRegisteredById(user.getId());

        return JSON.toJSONString(registeredService.getRegisteredById(id));
    }



}
