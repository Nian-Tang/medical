package com.medical.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medical.entity.Category;
import com.medical.mapper.CategoryMapper;
import com.medical.service.CategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 药品分类 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/category")
public class CategoryController {

    /**
     * <p>
     * 药品分类查询
     * </p>
     *
     * @since 2022-08-17
     */
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getcategory")
    public Object getcategory(){
        Page<Category> page = new Page<>(1,3);    //分页
        IPage iPage = categoryService.page(page, new QueryWrapper<>());  // 分页查询
        return JSON.toJSONString(iPage);   //返回JSON格式结果

    }



}
