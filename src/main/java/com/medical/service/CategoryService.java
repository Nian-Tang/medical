package com.medical.service;

import com.medical.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 药品分类 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@RequestMapping
public interface CategoryService extends IService<Category> {

}
