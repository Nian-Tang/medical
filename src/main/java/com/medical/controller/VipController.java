package com.medical.controller;

import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.service.UserService;
import com.medical.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/medical/vip")
public class VipController {
    @Autowired
    VipService vipService;
    @Autowired
    UserService userService;

    //我的会员
    @RequestMapping("/selVip")
    public Map<String, Object> selVip(HttpSession session){
        User user = (User) session.getAttribute("user");
        Vip vips = vipService.getById(user.getVipId());
        HashMap<String, Object> map = new HashMap<>();
        if (user.getVipId()==0){
            map.put("msg","穷逼，会员都充不起");
            return map;
        }else {
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("data",vips);
            return map;
        }
    }

    //开通会员/续费
    @RequestMapping("/insVip")
    public Map<String,Object> insVip(HttpSession session,Vip vip) throws ParseException {
        User user = (User) session.getAttribute("user");

        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ca.add(Calendar.DATE,31);
        String s = ca.getTime().toLocaleString();

        Vip v = vipService.getById(user.getVipId());

        HashMap<String, Object> map = new HashMap<>();
        System.out.println("======================>"+user.getVipId());
        if (user.getVipId() == 0){

            vip.setRegisterDate(new Date());
            vip.setExpireDate(sim.parse(s));
            boolean res = vipService.save(vip);

//        System.out.println("点你吗=>>>>>"+user.getId());
            user.setVipId(vip.getId());
            userService.updateById(user);

            map.put("code",200);
            map.put("msg","新增成功");
            map.put("data",res);
            return map;
        }
        else if (new Date().getTime()>v.getExpireDate().getTime()){
            System.out.println("============================>"+user.getVipId());

            v.setExpireDate(sim.parse(s));
            boolean b = vipService.updateById(v);
            map.put("code",200);
            map.put("msg","续费成功");
            map.put("data",b);
            return map;
        }
        return null;
    }

}
