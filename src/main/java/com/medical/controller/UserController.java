package com.medical.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


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
    UserMapper userMapper;
    /**
     * 注册用户
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody User user){
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",user.getUsername());
        List<User> user1 = userMapper.selectByMap(map);
        user1.forEach(System.out::println);
        if (user1.isEmpty()){
            user.setId(0).setUState("正常");
            userService.save(user);
            return true;
        }else
        return false;
    }

    /**
     * 登录
     */
    @GetMapping("/login")
    public Object userLogin(@RequestBody User user,HttpSession session){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        User user1 = userMapper.selectOne(wrapper);
        session.setAttribute("user",user1);

        if (user1==null){
            System.out.println("未找到该用户！请注册！");
            return false;
        }
        String uState = user1.getUState();
        if (uState.equals("正常")){
            System.out.println("登录成功！");
            return true;
        }else
            System.out.println("账号处于异常状态！");
            return false;

    }

    /**
     * 修改密码
     * JiaJieTang
     */
    @PostMapping("updatePassword")
    public Boolean updatePassword(@RequestBody User user,@RequestParam("newPassword") String newPassword){
        QueryWrapper<User> uWrapper = new QueryWrapper<>();
        uWrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        User one = userService.getOne(uWrapper);
        if(one!=null){
            one.setPassword(newPassword);
            userService.updateById(one);
            return true;
        }
        return false;
    }

    /**
     * 修改收货地址
     * @param user
     * @return
     */
    @PutMapping("/user")
    public Boolean userUpdate(@RequestBody User user){
        System.out.println(user);
        UpdateWrapper<User> wrapper =new UpdateWrapper();
        wrapper.eq("id", user.getId()).set("harvestAddress",user.getHarvestAddress());
        boolean save = userService.update(wrapper);
        return save;
    }

    /**
     * 查询用户收货地址
     * @return
     * LIMU
     */
    @GetMapping("/useraddress")
    public Object listUserAddress(HttpSession session){
        User user = (User)session.getAttribute("user");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        List<User> user1 =  userService.list(wrapper);
        return user1.get(0).getHarvestAddress();
    }

    /**
     * 查询医生信息
     * @param user
     * LIMU
     * @return
     */
    @GetMapping("/userdoctor")
    public Object listDoctor(@RequestBody User user){
        System.out.println(user);
        List<User> users = userService.getdoctor(user);
        return users;
    }

    /**
     * 分页查询用户
     * LIMU
     * @return
     */
    @GetMapping("/listuser")
    public List<User> listUser(){
        Page<User> userIPage = new Page<>(1,5);
        IPage<User> iPage = userMapper.selectPage(userIPage,null);
        List<User> list = iPage.getRecords();
        System.out.println("总页数： "+iPage.getPages());
        System.out.println("总记录数： "+iPage.getTotal());
        return list;
    }
    /**
     * 用户封号和解封功能
     * LIMU
     * @return
     */
    @PutMapping("/userState")
    public Object userState(@RequestParam("id") int id){
        User user = userMapper.selectById(id);
        if (user.getUState().equals("正常")){
            user.setUState("封号");
            return userService.updateById(user);
        }else if (user.getUState().equals("封号")){
            user.setUState("正常");
            return userService.updateById(user);
        }
        return false;
    }
}
