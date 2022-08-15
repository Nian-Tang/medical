package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.mapper.UserMapper;
import com.medical.mapper.VipMapper;
import com.medical.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZhangPan
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/vip")
public class VipController {

    @Autowired
    private VipMapper vipMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 会员充值续费功能到期充值
     * @param num
     * @param session
     * @return
     */
    @PostMapping("/vipBbs")
    public Map<String,Object> vipBbs(@RequestParam("num") Integer num, HttpSession session){
        User user=(User) session.getAttribute("user");
        Map<String,Object> map=new HashMap<>();
        Vip vip = vipMapper.selectById(user.getVipId());
        Vip vip2 = new Vip();


       if(user.getVipId()==null){
            vip2.setRegisterDate(new Date());
            vip2.setExpireDate(new Date());
            vipMapper.insert(vip2);
            vipMapper.updateTime(num);

            user.setVipId(vip2.getId());
            userMapper.updateById(user);
            map.put("code","200");
            map.put("msg","续费成功成功");
        }
        else{
            if(new Date().getTime()>vip.getExpireDate().getTime()){
                vip.setRegisterDate(new Date());
                vip.setExpireDate(new Date());
                vipMapper.updateTime(num);
                map.put("code","200");
                map.put("msg","续费成功成功");
            }
            else {
                Vip vip1 = vipMapper.selectById(user.getId());
                vipMapper.updateTime(num);
                map.put("code", "200");
                map.put("msg", "充值成功");
                map.put("data", vip1);
            }
        }
        return map;
    }
}
