package com.medical.controller;


import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.service.impl.RegisteredServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 预约挂号 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/registered")
public class RegisteredController {
    @Autowired
    RegisteredServiceImpl registeredService;

    /**
     * 查询挂号预约
     * @param session
     * @return
     */
    @GetMapping("selRegistered")
    public List<Registered> selRegistered(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Registered> registereds = registeredService.selRegistered(user.getId());
        return registereds;
    }
}
