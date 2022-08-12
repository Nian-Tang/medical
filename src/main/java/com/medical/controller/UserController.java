package com.medical.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
//import cn.org.atool.fluent.mybatis.base.crud.IQuery;
//import cn.org.atool.fluent.mybatis.base.crud.JoinBuilder;
//import com.medical.entity.User;
//import com.medical.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;

import javax.management.Query;


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
     * 注册用户
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody User user){
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",user.getUsername());
        List<User> user1 = userMapper.selectByMap(map);
        user1.forEach(System.out::println);
        if (user1.isEmpty()){
            userService.save(user);
            return true;
        }else
        return false;
    }

    /**
     * 登录
     */
    @GetMapping("/login")
    public Object userLogin(@RequestBody User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        List<User> user1 = userService.list(wrapper);
        if (user1.isEmpty()){
            return false;
        }else
            return true;
    }

    /**
     * 修改密码
     * JiaJieTang
     */
    @PostMapping("updatePassword")
    public Boolean updatePassword(@RequestBody User user){
        System.out.println(user);
        boolean save = userService.updateById(user);
        return save;
    }


    /**
     * 修改收货地址
     * @param user
     * @return
     */
    @PutMapping("/userUpdate")
    public Boolean userUpdate(@RequestBody User user){
        System.out.println(user);
        UpdateWrapper<User> wrapper =new UpdateWrapper();
        wrapper.eq("id", user.getId()).set("harvest_address",user.getHarvest_address());
        boolean save = userService.update(wrapper);
        return save;
    }

    /**
     *
     *
     *
     *
     *
     */
}
