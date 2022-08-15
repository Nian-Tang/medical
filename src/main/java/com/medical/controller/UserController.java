package com.medical.controller;


import com.medical.entity.Consulting;
import com.medical.entity.User;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("findCases/{id}")
    public List<User> findCases(@PathVariable Integer id){
        List<User> cases=userService.findCases(id);
        return cases;
    }





    @GetMapping("byCases/{id}")
    public List<User> byCases(@PathVariable Integer id){
        List<User> cases=userService.byCases(id);
        List<Consulting> list=new ArrayList<>();
        for (User aCase : cases) {
            list.add(aCase.getConsulting()) ;
        }
        return cases;
    }




}
