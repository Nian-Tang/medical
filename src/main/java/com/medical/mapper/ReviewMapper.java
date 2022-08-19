package com.medical.mapper;

import com.medical.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface ReviewMapper extends BaseMapper<Review> {

    Boolean saveDrugReview(Integer userId, Integer DrugId, String userReview);
}
