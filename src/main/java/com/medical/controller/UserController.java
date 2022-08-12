package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 修改
     * @param user
     * @return
     */
    @PutMapping("/userUpdate")
    public boolean userUpdate(@RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId()).set("harvest_address", user.getHarvest_address());
        boolean update = userService.update(updateWrapper);
        return update;
    }


//    /**
//     * 条件查询
//     * @param user
//     * @return
//     */
//    @GetMapping("/userSelect")
//    public List<User> userSelect(@RequestBody User user) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id", user.getId());
//        QueryChainWrapper<User> query = userService.query();
//
//        return query;
//    }
//
//
//    /**
//     * 分页查询
//     * @param user
//     * @return
//     */
//    @GetMapping("/userSelectPage")
//    public List<User> userSelectPage(@RequestBody User user) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id", user.getId());
//        Page<User> page = new Page<>(1, 2);
//
//        IPage iPage = userMapper.selectPage(page, queryWrapper);
//        List records = iPage.getRecords();
//        return records;
//    }
//
//
//    /**
//     * 模糊查询
//     * @param user
//     * @return
//     */
//    @GetMapping("/userSelectLike")
//    public List<User> userSelectLike(@RequestBody User user) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.like("harvest_address", "2");
//
//        List<User> users = userMapper.selectList(queryWrapper);
//        return users;
//    }
//
//    /**
//     * 删除
//     * @param user
//     * @return
//     */
//
//    @DeleteMapping("/userDelete")
//    public  boolean userDelete(@RequestBody User user) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id", user.getId());
//        boolean remove = userService.remove(queryWrapper);
//        return remove;
//    }
//
//
//    /**
//     * 添加
//     * @param user
//     * @return
//     */
//    @PostMapping("/userInsert")
//    public  boolean userInsert(@RequestBody User user) {
//        boolean save = userService.save(user);
//        return save;
//    }
//
//
//    @GetMapping()
//    public void select(){
////        userMapper.selectJoinList
//    }


}
