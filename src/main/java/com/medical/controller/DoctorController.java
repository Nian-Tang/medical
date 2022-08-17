package com.medical.controller;


import com.medical.entity.Consulting;
import com.medical.entity.User;
import com.medical.mapper.ConsultingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

}
