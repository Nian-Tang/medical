package com.medical.mapper;

import com.medical.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface ReviewMapper extends BaseMapper<Review> {
 List<Review> selectReviewJoinUserJoinMunutyJoinDrug(@Param("uid") int uid);
}
