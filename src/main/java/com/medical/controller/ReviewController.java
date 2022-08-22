package com.medical.controller;


import com.medical.entity.Drug;
import com.medical.entity.Review;
import com.medical.entity.User;
import com.medical.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RestController
@RequestMapping("/medical/review")
public class ReviewController {
    @Autowired
    ReviewMapper reviewMapper;

    /**
     *  新增用户药品评论 李沅斌
     * @param drug
     * @param userId
     * @param UserReview
     * @return
     */
    @PostMapping("/saveDrugReview")
    public Map<String ,Object> saveDrugReview(@RequestBody Drug drug, @RequestParam Integer userId,@RequestParam String UserReview){

        Map<String ,Object> map = new HashMap<>();
        Boolean saveReview = reviewMapper.saveDrugReview(userId,drug.getId(),UserReview);
        map.put("200","code");
        map.put("评论增加成功","msg");
        map.put("true",saveReview);
        return map;
    }
}