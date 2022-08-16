package com.medical.controller;



import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.Munity;
import com.medical.service.MunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 社区 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/munity")
public class MunityController {
    @Autowired
    private MunityService munityService;

    @PutMapping("updateMunityCtate")
    public void updateMunity(@RequestBody  Munity munity){
        UpdateWrapper<Munity> munityUpdateWrapper=new UpdateWrapper<>();
        munityUpdateWrapper.eq("id",munity.getId()).set("c_state","封号");
        munityService.update(munityUpdateWrapper);
    }



}
