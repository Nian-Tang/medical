package com.medical.web;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.*;
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
    ConsultingServiceImpl consultingServiceImpl;
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersServiceImpl ordersServiceImpl;

    //开通VIP
    @PostMapping("/openvip")
    public Object openVip(@RequestBody int num, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return Result.fail("未登录");
        Vip vip = new Vip();
        Date date1 = vip.getExpireDate();
        Date date2 = new Date();
        if (user.getVipId() == null || date1.before(date2)) {//判断时间date1是否在date2之前
            vip.setRegisterDate(new Date());//开始时间
            //开始时间加一个num个月
            Calendar cal = Calendar.getInstance();
            cal.setTime(vip.getRegisterDate());
            cal.add(Calendar.MONTH, num);

            vip.setExpireDate(cal.getTime());//结束时间
            vipServiceImpl.save(vip);
            user.setVipId(vip.getId());
            userServiceImpl.save(user);
            return Result.success("开通成功");
        } else {
            //结束时间加一个num个月
            Calendar cal = Calendar.getInstance();
            cal.setTime(vip.getExpireDate());
            cal.add(Calendar.MONTH, num);

            UpdateWrapper<Vip> vipUpdateWrapper = new UpdateWrapper<>();
            vipUpdateWrapper.eq("id", user.getVipId()).set("expire_date", cal.getTime());
            vipServiceImpl.update(vipUpdateWrapper);

            return Result.success("续费成功");
        }
    }

    //查询我的病史
    @GetMapping("/selectUserJoinConcernMapper")
    public Map<String, Object> selectUserJoinConcernMapper(@RequestParam int uid) {
        List<Consulting> consultings = consultingServiceImpl.selectUserJoinConsultingMapper(uid);
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
}
