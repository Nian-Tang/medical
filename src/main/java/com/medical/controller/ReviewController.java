package com.medical.controller;


import com.medical.entity.Review;
import com.medical.entity.User;
import com.medical.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    ReviewService reviewService;

    /**
     * 杨俊武
     * 查询评论接口
     * @return
     */
    @GetMapping("selectReviewJoinUserJoinMunutyJoinDrug")
    public List<Review> selectReviewJoinUserJoinMunutyJoinDrug(HttpSession session){
        User user = (User)session.getAttribute("user");
        Integer id = user.getId();
        List<Review> reviews = reviewService.selectReviewJoinUserJoinMunutyJoinDrug(id);
        return reviews;
    }
}
