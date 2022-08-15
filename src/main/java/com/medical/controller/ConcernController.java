package com.medical.controller;


import com.medical.entity.User;
import com.medical.service.impl.ConcernServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    ConcernServiceImpl concernService;

    /**
     *查询关注的用户
     * JiaJieTang
     * @param session
     * @return
     */
    @GetMapping("selectConcern")
    public List<User> selectConcern(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<User> users = concernService.selectConcern(user.getId());
        return users;
    }
}
