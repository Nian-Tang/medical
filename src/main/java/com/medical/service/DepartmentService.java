package com.medical.service;

import com.medical.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.Doctor;

import java.util.List;

/**
 * <p>
 * 科室 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
public interface DepartmentService extends IService<Department> {
    List<Department> likeDoAndDH(String dName);
}
