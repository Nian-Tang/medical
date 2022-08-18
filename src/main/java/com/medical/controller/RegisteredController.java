package com.medical.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.mapper.RegisteredMapper;
import org.springframework.web.bind.annotation.GetMapping;
import com.alibaba.fastjson.JSON;
import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.service.RegisteredService;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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



    @Autowired
    RegisteredMapper registeredMapper;

    @GetMapping("/registereds")
    public Page<Registered> registered(@RequestParam(value = "start",defaultValue = "1") int start,
                                       @RequestParam(value = "size" ,defaultValue = "10") int size){
        Page<Registered> registeredPage = registeredMapper.selectPage(new Page<>(start,size),null);
        return registeredPage;
    }

}
