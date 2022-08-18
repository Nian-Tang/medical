package com.medical.mapper;

import com.medical.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.Doctor;

import java.util.List;

/**
 * <p>
 * 科室 Mapper 接口
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> likeDoAndDH(String dName);
}
