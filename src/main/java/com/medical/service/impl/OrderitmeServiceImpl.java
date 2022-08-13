package com.medical.service.impl;

import com.medical.entity.Orderitme;
import com.medical.mapper.OrderitmeMapper;
import com.medical.service.OrderitmeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单项 服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-11
 */
@Service
public class OrderitmeServiceImpl extends ServiceImpl<OrderitmeMapper, Orderitme> implements OrderitmeService {
@Autowired
OrderitmeMapper orderitmeMapper;
    @Override
    public List<Orderitme> selectOrderItme(int oid) {
        return orderitmeMapper.selectOrderItme(oid);
    }
}
