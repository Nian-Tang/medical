package com.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.medical.entity.User;
import com.medical.entity.Vip;
import com.medical.mapper.VipMapper;
import com.medical.service.VipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiaJieTang
 * @since 2022-08-15
 */
@Service
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements VipService {
    @Autowired
    VipMapper vipMapper;

    public Vip recharge(Integer uid,Integer time){
        Vip nVip = new Vip();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, time);//time，是用户充值的月数
        Date date = calendar.getTime();
        nVip.setExpireDate(date);
        nVip.setRegisterDate(new Date());
        nVip.setUid(uid);
        return nVip;
    }

    public Vip renewal(Integer uid,Integer time){
        QueryWrapper<Vip> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        Vip vip = vipMapper.selectOne(wrapper);
        if(vip!=null){
            Date expireDate = vip.getExpireDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expireDate);
            calendar.add(Calendar.MONTH,time);
            Date rDate=calendar.getTime();
            vip.setExpireDate(rDate);
            return vip;
        }else{
            return null;
        }
    }
}
