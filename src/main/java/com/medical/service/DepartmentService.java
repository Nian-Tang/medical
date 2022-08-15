package com.medical.service;

import com.medical.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 科室 服务类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */

@Service
public interface DepartmentService extends IService<Department> {

    List<Department> getDep(int id);

    List<Department> getks(int hid);
}
