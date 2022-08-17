package com.medical.service.impl;

import com.medical.entity.Concern;
import com.medical.entity.User;
import com.medical.mapper.ConcernMapper;
import com.medical.mapper.UserMapper;
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

    @Autowired
    ConcernMapper concernMapper;
    @Autowired
    UserMapper userMapper;


    /**
     * 关注
     * @param uid
     * @param uiid= id
     * @param id=uiid
     * @return
     */
    @Override
    public Object addConcern(int uid, int uiid, int id) {
        return concernMapper.addConcern(uid,uiid);
    }

    @Override
    public List<Concern> getAllConcern() {
        return concernMapper.getAllConcern();
    }

    /**
     * 删除：取消关注
     *
     * @param uiid
     * @return
     */
    @Override
    public boolean closeConcern(int uid,int uiid) {
        return concernMapper.closeConcern(uid,uiid);
    }

}
