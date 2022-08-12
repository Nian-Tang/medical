package com.medical.controller;


import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.JoinBuilder;
import com.medical.entity.User;
import com.medical.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    UserServiceImpl userService;
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
}
