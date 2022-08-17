package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    /**
     *
     *收货地址CRUD
     *
     * @author zdh
     * @since 2022-08-11
     */
    @PostMapping("/addharvestaddress")
    public boolean addharvestaddress(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id","1").set("harvest_address","雨花区");
        return userService.update(updateWrapper);
    }

    @GetMapping("/getharvestaddress")
    public List<User> getharvestaddress(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("harvest_address").eq("id","1");
         List<User> users = userMapper.selectList(queryWrapper);
         return users;
    }

    @PostMapping("/deleteharvestaddress")
    public boolean deleteharvestaddress(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id","2").set("harvest_address","null");
        return   userService.update(updateWrapper) ;

    }






}
