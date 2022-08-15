package com.medical.controller;


import com.medical.config.Result;
import com.medical.entity.Concern;
import com.medical.entity.User;
import com.medical.service.impl.ConcernServiceImpl;
import com.medical.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 关注 前端控制器
 * </p>
 *
 * @author GongHaiBo
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/concern")
public class ConcernController {

    @Autowired
    ConcernServiceImpl concernServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;


    /**
     * 关注
     * @param uid
     * @param uiid
     * @param id
     * @return
     */
    @PostMapping("/addConcern")
    public Object addConcern(@RequestParam("uid") int uid,
                             @RequestParam("uiid") int uiid,
                             @RequestParam("id") int id) {
        User user = userServiceImpl.getUserId(id);
        if (user != null) {
            if (uiid == id) {
                List<Concern> concernList = concernServiceImpl.getAllConcern();
                for (Concern con : concernList){
                    if (con.getUid()==uid && con.getUiid()==uiid){
                        return Result.fail("已关注该用户！");
                    }
                    break;
                }
                concernServiceImpl.addConcern(uid, uiid, id);
                return Result.success("关注成功！");
            } else if (uid == id) {
                return Result.fail("不可以自己关注自己哦！");
            }
        }
        return Result.fail("用户不存在！");
    }

    /**
     * 查询所有关注信息
     * @return
     */
    @GetMapping("/getAllConcern")
    public Object getAllConcern(){
        return concernServiceImpl.getAllConcern();
    }

    @DeleteMapping("/closeConcern")
    public Object closeConcern(@RequestParam("uid")int uid,@RequestParam("uiid") int uiid){
        concernServiceImpl.closeConcern(uid,uiid);
        return Result.success("已取消关注");
    }
}
