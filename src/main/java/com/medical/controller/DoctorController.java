package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Consulting;
import com.medical.entity.Doctor;
import com.medical.entity.User;
import com.medical.mapper.ConsultingMapper;
import com.medical.mapper.DepartmentMapper;
import com.medical.mapper.DoctorMapper;
import com.medical.mapper.UserMapper;
import com.medical.service.DoctorService;
import com.medical.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医生信息 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/doctor")
public class DoctorController {
    @Autowired
    private ConsultingMapper consultingMapper;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private UserService userService;
    /**
     * 医生查询有的用户 李沅斌
     * @param user
     * @param session
     * @return
     */
    @GetMapping("/selectDoctorUser")
    public Map<String ,Object> selectDoctorUser(@RequestBody User user, HttpSession session){
        Map<String ,Object> map = new HashMap<>();
        if (user.getDoid()==0){
            map.put("500","code");
            map.put("您不是医生","msg");
            return map;
        }
        List<Consulting> consultings = consultingMapper.selectDoctorUser(user.getDoid());
        map.put("consultings",consultings);
        map.put("200","code");
        map.put("查询成功","msg");
        return map;
    }

/*
添加医生id，同时user表里面增加新的用户id
 */

    @PostMapping("/adddo")
    public Map<String,Object> add(Doctor doctor){
        double add= doctorService.adddo(doctor);
        Integer id = doctor.getId();
        User user=new User();
        user.setDoid(id);
        user.setUsername(doctor.getTitle());
        user.setName(doctor.getBrief());
        userService.addid(user);
        HashMap<String,Object> map= new HashMap<>();
        map.put("code","200");
        map.put("msg","增加成功");
        map.put("data",add);
        return map;
    }



}
