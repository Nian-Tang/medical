package com.medical.controller;


import com.medical.entity.Concern;
import com.medical.entity.Doctor;
import com.medical.entity.Munity;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/concern")
public class ConcernController {
    @Autowired
    ConcernMapper concernMapper;


    @GetMapping("/selectConcern")
    public List<User> selectConcern(@RequestBody User user){

        //查询用户关注的医生以及用户
        //1，链表查询即可实现
        List<User> users = concernMapper.concerns(user.getId());
        System.out.println(users);
        return users;
    }
    @GetMapping("concernessay")
    public List<Munity> munities(@RequestBody User user){

        //查询用户收藏的文章
        //三表查询即可
        List<Munity> munities = concernMapper.concernessay(user.getId());
        return munities;
    }


}
