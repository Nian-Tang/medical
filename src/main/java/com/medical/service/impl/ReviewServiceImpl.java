package com.medical.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medical.entity.Review;
import com.medical.mapper.ReviewMapper;
import com.medical.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Override

    public List<Review> selectReviewJoinUserJoinMunutyJoinDrug(int uid) {
        return reviewMapper.selectReviewJoinUserJoinMunutyJoinDrug(  uid);
    }
}
