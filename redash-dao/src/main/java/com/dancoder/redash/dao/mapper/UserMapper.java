package com.dancoder.redash.dao.mapper;

import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.dao.dataobject.UserDO;

import java.util.List;

/**
 * @author dancoder
 */
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);
 
    Long insert(UserDO userDO);

    List<UserDO> findUsersByCondition(UserConditionVO vo);
}
