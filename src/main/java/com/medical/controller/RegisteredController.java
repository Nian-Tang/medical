package com.medical.controller;


import com.medical.entity.Registered;
import com.medical.entity.User;
import com.medical.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    RegisteredService registeredService;

    //我的预约
    @RequestMapping("/selectReg")
    public Map<String,Object> getReg(HttpSession session){
        User user = (User) session.getAttribute("user");
        Registered reg = registeredService.getReg(user.getId());
        HashMap<String, Object> map = new HashMap<>();
        if (reg==null){
            map.put("msg","该账号没有预约");
            map.put("data",reg);
            return map;
        }
        else if (reg.getUser().getId()==user.getId()){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("data",reg);
            return map;
        }
        return null;
    }

}
