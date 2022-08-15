package com.medical.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.medical.entity.User;
import com.medical.mapper.UserMapper;
import com.medical.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author GongHaiBo
 * @since 2022-08-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * 修改密码
     *
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    @Override
    public String updatePasswordByUsername(String username, String password, String newPassword) {
        User user = userMapper.getUsername(username);
        if (user != null) {
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)) {
                System.out.println("输入不能为空");
                return "输入不能为空";
            } else if (!user.getPassword().equals(password)) {
                System.out.println("原密码错误");
                return "原来密码错误";
            } else if (user.getPassword().equals(newPassword)) {
                System.out.println("新密码不能与旧密码相同！");
                return "新密码不能与旧密码相同！";
            } else if (user.getPassword().equals(password)) {
                userMapper.updatePasswordByUsername(username, newPassword);
                System.out.println("密码修改成功");
                return "密码修改成功";
            } else
                System.out.println("用户密码未修改");
            return "用户密码未修改";
        } else {
            System.out.println("5");
            return "用户不能为空";
        }

    }

    /**
     * 根据用户名查询信息
     *
     * @param username
     * @return
     */
    @Override
    public User getUsername(String username) {
        return userMapper.getUsername(username);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getUserId(int id) {
        return userMapper.getUserId(id);
    }


    /**
     * 根据用户uid（用户表的外键）查询用户关注的医生
     *
     * @param uid
     * @return
     */
    @Override
    public List<User> getAllMyConcernDoctor(int uid) {
        return userMapper.getAllMyConcernDoctor(uid);
    }


}
