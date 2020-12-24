package com.dancoder.redash.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.dao.dataobject.UserDO;

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
     * 根据条件获取用户列表
     * @param vo
     * @return
     */
    List<UserDO> findUsersByCondition(UserConditionVO vo);
}
