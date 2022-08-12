package com.medical.web;

import com.baomidou.mybatisplus.extension.api.R;
import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.service.impl.UserServiceImpl;
import com.medical.service.impl.VipServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/medical/fore")
public class ForeRESTController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    VipServiceImpl vipServiceImpl;

    @PostMapping("/openvip")
    public Object openVip(@RequestBody int num, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null) return Result.fail("未登录");
        Vip vip = new Vip();
        if (user.getVipId()==null){
            vip.setRegisterDate(new Date());
            vipServiceImpl.save(vip);
            user.setVipId(vip.getId());
            userServiceImpl.save(user);
        }else {
            vipServiceImpl.updateTime(num,user.getVipId());//num 加月份
        }
        return Result.success("开通成功");
    }
}
