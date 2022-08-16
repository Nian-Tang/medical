package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.service.impl.UserServiceImpl;
import com.medical.service.impl.VipServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  vip表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/medical/vip")
public class VipController {
    @Autowired
    VipServiceImpl vipService;

    @Autowired
    UserServiceImpl userService;

    /**
     * 充值会员
     * @param session
     * @param time 充值时间 n个月
     * @return
     */
    @PostMapping("recharge")
    public boolean recharge(HttpSession session,@RequestParam("time") Integer time){
        User user = (User) session.getAttribute("user");
        if(time!=null){
            Vip vip = vipService.recharge(user.getId(), time);
            boolean save = vipService.save(vip);
            return save;
        }
        return false;
    }

    /**
     * 会员续费接口
     * @param session
     * @param time 续费时间 n个月
     * @return
     */
    @PostMapping("renewal")
    @ResponseBody
    public Map renewal(HttpSession session,@RequestParam("time") Integer time){
        User user = (User) session.getAttribute("user");
        Vip vip= vipService.renewal(user.getId(), time);
        Map<String, String> map = new HashMap<>();
        if(vip!=null){
            UpdateWrapper<Vip> uWrapper = new UpdateWrapper<>();
            uWrapper.eq("uid", user.getId()).set("expire_date", vip.getExpireDate());
            vipService.update(uWrapper);
            map.put("success","续费成功");
            return map;
        }
        map.put("error","请先充值");
        return map;
    }
}
