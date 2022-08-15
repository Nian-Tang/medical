package com.medical.controller;

import com.medical.custom.result.R;
import com.medical.entity.User;

import com.medical.service.UserService;
import com.medical.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.medical.service.impl.UserServiceImpl;
import com.medical.service.impl.VipServiceImpl;
import com.medical.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired 
    UserService userService;
    @Autowired
    UserServiceImpl userServiceImpl;
  
     /**
     * 登入
     * */

    @PostMapping(path = "/login")
    public R login(@RequestBody User user) {
        User loginUser = userService.login(user);
        if (null != loginUser) {
            String token = JwtUtil.generateToken(loginUser);
            return R.ok().put("token", token);
        }
        return R.error("账号或密码错误！");
    }
   
    /**
     * 注册
     * */
    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        String userName = user.getUsername();
        userName = HtmlUtils.htmlEscape(userName);
        user.setName(userName);
        List<User> users = userServiceImpl.selectByUserName(userName);
        if (users.size() == 0) {
            userServiceImpl.save(user);
            return Result.success("注册成功");
        }else {
            return Result.success("用户已存在");
        }
    }


}
