package com.medical.service.impl;

import com.medical.entity.Department;
import com.medical.mapper.DepartmentMapper;
import com.medical.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 科室 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDep(int id) {
        return departmentMapper.getDep(id);
    }

    @Override
    public List<Department> getks(int hid) {
        return departmentMapper.getks(hid);
    }
}
