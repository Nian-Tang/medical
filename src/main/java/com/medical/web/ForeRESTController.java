package com.medical.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.*;
import com.medical.mapper.VaccineMapper;
import com.medical.mapper.VipMapper;
import com.medical.service.OrdersService;
import com.medical.service.impl.ConsultingServiceImpl;
import com.medical.service.impl.OrdersServiceImpl;
import com.medical.service.impl.UserServiceImpl;
import com.medical.service.impl.VipServiceImpl;
import com.medical.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/medical/fore")
public class ForeRESTController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    VipServiceImpl vipServiceImpl;
    @Autowired
    VipMapper vipMapper;
    @Autowired
    ConsultingServiceImpl consultingServiceImpl;
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersServiceImpl ordersServiceImpl;

    //开通VIP,续费
    @PostMapping("/openvip")
    public Object openVip(@RequestBody int num, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return Result.fail("未登录");
        QueryWrapper<Vip> vipQueryWrapper = new QueryWrapper<>();
        vipQueryWrapper.eq("id",1);
        List<Vip> vip = vipServiceImpl.list(vipQueryWrapper);
        Date date1 = vip.get(0).getExpireDate();
        Date date2 = new Date();
        if (vip == null || date1.before(date2)) {//判断时间date1是否在date2之前
            vip.get(0).setRegisterDate(new Date());//开始时间
            //开始时间加一个num个月
            // 使用默认时区和语言环境获得一个日历
            Calendar cal = Calendar.getInstance();
            cal.setTime(vip.get(0).getRegisterDate());
            cal.add(Calendar.MONTH, num);

            vip.get(0).setExpireDate(cal.getTime());//结束时间
            vipServiceImpl.saveBatch(vip);
            user.setVipId(vip.get(0).getId());
            userServiceImpl.save(user);
            return Result.success("开通成功");
        } else {
            //结束时间加一个num个月
            Calendar cal = Calendar.getInstance();
            cal.setTime(vip.get(0).getExpireDate());
            cal.add(Calendar.MONTH, num);

            UpdateWrapper<Vip> vipUpdateWrapper = new UpdateWrapper<>();
            vipUpdateWrapper.eq("id", user.getVipId()).set("expire_date", cal.getTime());
            vipServiceImpl.update(vipUpdateWrapper);

            return Result.success("续费成功");
        }
    }

    //查询我的病史
    @GetMapping("/selectUserJoinConcern")
    public Map<String, Object> selectUserJoinConcern(@RequestParam int uid) {
        List<Consulting> consultings = consultingServiceImpl.selectUserJoinConsulting(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "查询成功！");
        map.put("data", consultings);
        return map;
    }

    //退款
    @GetMapping("/reimburse")
    public Object reimburse(@RequestParam("oid") int oid, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null)
            return Result.fail("未登录");
        Orders orders = ordersServiceImpl.getById(oid);
        orders.setOrderState(OrdersService.backPay);
        ordersServiceImpl.saveOrUpdate(orders);
        return Result.success("退款成功");
    }

    //黄金支付时间

}
