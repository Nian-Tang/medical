package com.medical.mapper;

import com.medical.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 药品分类 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
