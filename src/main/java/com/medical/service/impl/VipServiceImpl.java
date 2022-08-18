package com.medical.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medical.entity.Vip;
import com.medical.mapper.VipMapper;
import com.medical.service.VipService;
import org.springframework.stereotype.Service;

@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements VipService {
}
