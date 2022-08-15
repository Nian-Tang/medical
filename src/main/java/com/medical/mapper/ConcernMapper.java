package com.medical.mapper;

import com.medical.entity.Concern;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medical.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 关注 Mapper 接口
 * </p>
 *
 * @author GongHaiBo
 * @since 2022-08-12
 */
@Mapper
public interface ConcernMapper extends BaseMapper<Concern> {


    /**
     * 关注
     * @param uid
     * @param uiid
     * @return
     */
     Integer addConcern(@Param("uid")int uid,@Param("uiid") int uiid);

    /**
     *查询所有关注信息
     * @return
     */
     List<Concern> getAllConcern();

    /**
     * 删除：取消关注
     * @param uid
     * @param uiid
     * @return
     */
     boolean closeConcern(@Param("uid") int uid, @Param("uiid") int uiid);
}
