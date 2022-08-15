package com.medical.controller;

import com.medical.entity.User;
import com.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private UserService userService;

//    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
//    public User get(@PathVariable int id) {
//        return userService.get(id);
//    }



    @PostMapping("/getUser")
    public Map<String, Object> getUser(int id) {
        List<User> getUser = userService.getUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "查询成功");
        map.put("data", getUser);
        return map;
    }

    @PostMapping("/adduser")
    public Map<String, Object> add(User user) {
        double add = userService.add(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "增加成功");
        map.put("data", add);
        return map;
    }

    @PutMapping("/update")
    public Map<String, Object> update(User user){
        double update = userService.update(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "更改成功");
        map.put("data", update);
        return map;
    }

    @PutMapping("/upuser")
    public Map<String, Object> upuser(User user){
        double update = userService.upuser(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "更改成功");
        map.put("data", update);
        return map;
    }


//    @DeleteMapping("/delete")
//    public Map<String, Object> delete(User user){
//        boolean delete = userService.delete(user);
//        HashMap<String, Object> map = new HashMap<>();
//        if (delete!=true){
//            map.put("msg", "删除失败");
//        }else {
//            map.put("code", "200");
//            map.put("msg", "删除成功");
//            map.put("data", delete);
//        }
//        return map;
//    }
}



