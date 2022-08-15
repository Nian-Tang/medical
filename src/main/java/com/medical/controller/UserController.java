package com.medical.controller;

import com.medical.custom.result.R;
import com.medical.entity.User;

import com.medical.service.UserService;
import com.medical.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author OuYangGenChuan
 * @since 2022-08-14
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {
    @Autowired  private UserService userService;


    @PostMapping(path = "/login")
    public R login(@RequestBody User user) {
        User loginUser = userService.login(user);
        if (null != loginUser) {
            String token = JwtUtil.generateToken(loginUser);
            return R.ok().put("token", token);
        }
        return R.error("账号或密码错误！");
    }


}
