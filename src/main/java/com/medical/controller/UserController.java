package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.config.Result;
import com.medical.entity.User;
import com.medical.service.UserService;
import com.medical.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author GongHaibo
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserService userService;


    /**
     * 根据用户名修改密码
     * GongHaiBo
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    @PutMapping("/updatePasswordByUsername")
    public Object updatePasswordByUsername(@RequestParam("username") String username,
                                           @RequestParam("password") String password,
                                           @RequestParam("newPassword") String newPassword){
       userServiceImpl.updatePasswordByUsername(username,password,newPassword);
       return Result.success("密码修改成功!");
    }

    /**
     *根据用户名获取该用户的所有信息
     * *GongHaiBo
     * @param username
     * @return
     */
    @GetMapping("/getUsername")
    public Object getUsername(@RequestParam String username){
        userServiceImpl.getUsername(username);
        return Result.success("成功获取用户名！");
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/getUserId")
    public Object getUserId(@RequestParam Integer id){
        return userServiceImpl.getUserId(id);
    }

    /**
     * 查询用户关注的所有的医生
     * @param uid
     * @return
     */
    @GetMapping("/getAllMyConcernDoctor")
    public Object getAllMyConcernDoctor(@RequestParam("uid") int uid){
        return userServiceImpl.getAllMyConcernDoctor(uid);
    }

}
