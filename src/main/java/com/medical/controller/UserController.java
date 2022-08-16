package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.medical.entity.Consulting;
import com.medical.entity.Orderitme;
import com.medical.entity.User;
import com.medical.mapper.ConsultingMapper;
import com.medical.mapper.OrderitmeMapper;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ConsultingMapper consultingMapper;
    @Autowired
    private OrderitmeMapper orderitmeMapper;

    /**
     * 查找患者
     */
    @GetMapping("findCases/{id}")
    public List<User> findCases(@PathVariable Integer id){
        List<User> cases=userService.findCases(id);
        return cases;
    }

    /**
     * 查找咨询内容
     */
    @GetMapping("byCases/{id}")
    public List<User> byCases(@PathVariable Integer id){
        List<User> cases=userService.byCases(id);
        List<Consulting> list=new ArrayList<>();
        for (User aCase : cases) {
            list.add(aCase.getConsulting()) ;
        }
        return cases;
    }
    /**
     * 登录功能
     */

    @PostMapping("/login")
    public Map<String,Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session){
        Map<String,Object> map=new HashMap<>();
        User user= userMapper.selectOne(new QueryWrapper<User>().eq("username",username)
                .eq("password",password));
        if(ObjectUtils.isEmpty(user)){
            map.put("code","500");
            map.put("msg","账号密码错误");
            map.put("data",user);
        }else {
            map.put("code","200");
            map.put("msg","登录成功");
            map.put("data",user);
            session.setAttribute("user",user);
        }
        return map;
    }
    /**
     * 注册功能
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        String username= user.getUsername();
        Map<String,Object> map=new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password",user.getPassword());
        User username1=userMapper.selectOne(queryWrapper);
        if(ObjectUtils.isEmpty(username1)){
            map.put("code","200");
            map.put("msg","注册成功");
            userMapper.insert(user);
        }
        else {
            map.put("code","500");
            map.put("msg","用户名已存在");
        }
        return map;
    }

    /**
     * 根据用户id查询
     */
    @PostMapping("/getUser")
    public Map<String, Object> getUser(int id) {
        List<User> getUser = userService.getUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "查询成功");
        map.put("data", getUser);
        return map;
    }

    /**
     * 新增收货地址
     */
    @PostMapping("/adduser")
    public Map<String, Object> add(User user) {
        double add = userService.add(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "增加成功");
        map.put("data", add);
        return map;
    }

    /**
     *修改地址
     */
    @PutMapping("/update")
    public Map<String, Object> update(User user){
        double update = userService.update(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "更改成功");
        map.put("data", update);
        return map;
    }

    /**
     *修改用户收货地址
     */
    @PutMapping("/upuser")
    public Map<String, Object> upuser(User user){
        double update = userService.upuser(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "更改成功");
        map.put("data", update);
        return map;
    }

    /**
     * 历史病历
     * @param session
     * @return
     */
    @GetMapping("/Myhistory")
    public Map<String,Object> Myhistory(HttpSession session){
        User user =(User) session.getAttribute("user");
        List<Consulting> consultings = userMapper.selectUser(user);
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","成功");
        map.put("data",consultings);
        return map;
    }

    /**
     * 订单
     * @param session
     * @return
     */
    @GetMapping("/Myhistory1")
    public Map<String,Object> Myhistory1(HttpSession session){
        User user =(User) session.getAttribute("user");
        List<Orderitme> orderitmes = orderitmeMapper.selectOrderByUser(user);
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","成功");
        map.put("data",orderitmes);
        return map;
    }
}