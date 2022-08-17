package com.medical.service;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medical.entity.Consulting;
import com.medical.mapper.ConsultingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 * 关注 服务类
 * </p>
 *
 * @author GongHaibo
 * @since 2022-08-11
 */
public interface ConcernService extends IService<Concern> {

    /**
     * 关注
     * @param uid
     * @param uiid
     * @param id 用户表的id
     * @return
     */
    Object addConcern(@Param("uid")int uid, @Param("uiid") int uiid, int id);

    /**
     * 查询所有关注信息
     * @return
     */
    List<Concern> getAllConcern();

    /**
     * 删除：取消关注
     * @param uiid
     * @return
     */
    boolean closeConcern(@Param("uid") int uid,@Param("uiid") int uiid);
}
