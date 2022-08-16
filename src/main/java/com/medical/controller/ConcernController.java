package com.medical.controller;


import com.medical.entity.Munity;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 查询用户关注的医生以及用户 lyb
     * @param user
     * @return
     */
    @GetMapping("/selectConcern")
    public List<User> selectConcern(User user){
        List<User> users = concernMapper.concerns(user.getId());
        return users;
    }
    /**
     * 查询用户收藏的文章lyb
     * @param user
     * @return
     */
    @GetMapping("concernessay")
    public List<Munity> munities(@RequestBody User user){
        List<Munity> munities = concernMapper.concernessay(user.getId());
        return munities;
    }

}
