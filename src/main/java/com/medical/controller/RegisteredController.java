package com.medical.controller;


import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.mapper.RegisteredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    RegisteredMapper registeredMapper;
    //我预约的挂号
    @GetMapping("/registered")
    public Map<String,Object> registereds(@RequestBody User user){
        List<Registered> registereds =  registeredMapper.selectRegistered(user.getId());
        Map<String ,Object> map = new HashMap<>();
        if (registereds!=null){
            map.put("registereds",registereds);
            map.put("code","200");
            map.put("msg","查询我的挂号成功");
        }else {
            map.put("code","500");
            map.put("msg","查询我的挂号失败");
        }
        return map;
    }
}