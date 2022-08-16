package com.medical.controller;


import com.medical.entity.Department;
import com.medical.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 科室 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 科室查询 李豪
     */
    @PostMapping("/getDep")
    public Map<String, Object> get(int id){
        List<Department> getDepartment= departmentService.getDep(id);
        Map<String, Object> map=new HashMap<>();
        map.put("code", "200");
        map.put("msg", "查询成功");
        map.put("data", getDepartment);
        return map;
    }

    /**
     * 查询医院名，医院地址，科室名 李豪
     */
    @PostMapping("/getks")
    public Map<String, Object> getks(int hid){
        List<Department> getDepartment= departmentService.getks(hid);
        Map<String, Object> map=new HashMap<>();
        map.put("code", "200");
        map.put("msg", "查询成功");
        map.put("data", getDepartment);
        return map;
    }

}
