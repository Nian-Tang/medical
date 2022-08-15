package com.medical.service.impl;

import com.medical.entity.Concern;
import com.medical.entity.Doctor;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import com.medical.mapper.DoctorMapper;
import com.medical.service.ConcernService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 关注 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class ConcernServiceImpl extends ServiceImpl<ConcernMapper, Concern> implements ConcernService {

}
