package com.redash.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.redash.entity.UserDO;
import com.redash.queryvo.UserConditionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dancoder
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据email获取用户对象
     * @param email
     * @return
     */
    UserDO getByEmail(String email);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UserDO getById(@Param("id") Long id);

    /**
     * 根据条件获取用户列表
     * @param vo
     * @return
     */
    List<UserDO> findUsersByCondition(UserConditionVO vo);
}
