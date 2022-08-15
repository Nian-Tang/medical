package com.medical.controller;



import java.util.List;
import org.springframework.stereotype.Controller;
import com.medical.custom.result.R;
import com.medical.entity.User;
import com.medical.service.UserService;
import com.medical.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.web.bind.annotation.*;
import com.medical.service.impl.UserServiceImpl;
import com.medical.service.impl.VipServiceImpl;
import com.medical.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *

 */
@RestController
@RequestMapping("/medical/user")
public class UserController {
    @Autowired 
    UserService userService;
    @Autowired
    UserServiceImpl userServiceImpl;
  
     /**
     * 登入
     * */

    @PostMapping(path = "/login")
    public R login(@RequestBody User user) {
        User loginUser = userService.login(user);
        if (null != loginUser) {
            String token = JwtUtil.generateToken(loginUser);
            return R.ok().put("token", token);
        }
        return R.error("账号或密码错误！");
    }
   
    /**
     * 注册
     * */
    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        String userName = user.getUsername();
        userName = HtmlUtils.htmlEscape(userName);
        user.setName(userName);
        List<User> users = userServiceImpl.selectByUserName(userName);
        if (users.size()==0) {
            userServiceImpl.save(user);
            return Result.success("注册成功");
        }else {
            return Result.success("用户已存在");
        }
    }


    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserService userService;


    /**
     * 根据用户名修改密码
     * GongHaiBo
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    @PutMapping("/updatePasswordByUsername")
    public Object updatePasswordByUsername(@RequestParam("username") String username,
                                           @RequestParam("password") String password,
                                           @RequestParam("newPassword") String newPassword){
       userServiceImpl.updatePasswordByUsername(username,password,newPassword);
       return Result.success("密码修改成功!");
    }

    /**
     *根据用户名获取该用户的所有信息
     * *GongHaiBo
     * @param username
     * @return
     */
    @GetMapping("/getUsername")
    public Object getUsername(@RequestParam String username){
        userServiceImpl.getUsername(username);
        return Result.success("成功获取用户名！");
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/getUserId")
    public Object getUserId(@RequestParam Integer id){
        return userServiceImpl.getUserId(id);
    }

    /**
     * 查询用户关注的所有的医生
     * @param uid
     * @return
     */
    @GetMapping("/getAllMyConcernDoctor")
    public Object getAllMyConcernDoctor(@RequestParam("uid") int uid){
        return userServiceImpl.getAllMyConcernDoctor(uid);
    }

}
