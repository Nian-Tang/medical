package com.medical;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.*;
import com.medical.service.DoctorService;
import com.medical.service.MunityService;
import com.medical.service.UserService;
import com.medical.service.VipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MedicalApplicationTests {
    @Autowired
    MunityService munityService;
    @Autowired
    VipService vipService;
    @Autowired
    UserService userService;
    @Autowired
    DoctorService doctorService;

    @Test
    void contextLoads() {
        QueryWrapper<Munity> q = new QueryWrapper<>();
        q.like("subtitle","从");
        System.out.println(munityService.list(q));
    }

    @Test
    void dnm() throws ParseException {
        Vip vip = new Vip();
        User user = new User();
        vip.setRegisterDate(new Date());
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE,31);
        String s = ca.getTime().toLocaleString();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        vip.setExpireDate(sim.parse(s));

        boolean res = vipService.save(vip);
        int id = vip.getId();

        user.setId(2);
        user.setVipId(id);
        userService.updateById(user);
        int i = user.getVipId();
        System.out.println("userID为=>"+i);
        System.out.println("vipId为==>"+id);
        System.out.println(res);
    }

    @Test
    void get(){

        Vip v =new Vip();
        Date date = new Date();

        System.out.println(date.getTime());
//        System.out.println(vipService.getById(49));
        System.out.println(v.getExpireDate());
//        System.out.println(vipService.list());
    }

    @Test
    void Do(){
        List<Doctor> dh = doctorService.likeDoAndDH();
        System.out.println(dh);
    }



}
