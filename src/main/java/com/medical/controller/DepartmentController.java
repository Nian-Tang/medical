package com.medical.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.service.DepartmentService;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import com.medical.entity.Department;
import com.medical.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 科室 前端控制器
 * </p>
 *
 * @author GongHaiBo
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/medical/department")
public class DepartmentController {
@Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentMapper departmentMapper;


    /**
     * 根究科室名字查询科室
     * @param d_name
     * @return
     */
    @GetMapping("/getDepartment")
    public List<Department> getDepartment(@RequestParam String d_name){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("d_name",d_name);
        List<Department> departments = departmentMapper.selectList(queryWrapper);
        return departments;
    }

    /**
     * 查询所有的科室
     * @return
     */
    @GetMapping("/getAllDepartment")
    public Page<Department> getAllDepartment(@RequestParam(value = "start",defaultValue = "1") Integer start,
                                             @RequestParam(value = "size",defaultValue = "5") Integer size){
        Page<Department> departmentPage = departmentMapper.selectPage(new Page<>(start,size),null);
        return departmentPage;
    }

    @GetMapping("/departmentSelect")
    public List<Department> departmentSelect(@RequestParam Integer id){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        List<Department> departments = departmentMapper.selectList(queryWrapper);
        return departments;
    }
}
