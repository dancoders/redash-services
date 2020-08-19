package com.dancoder.redash.dao.mapper;

import com.dancoder.redash.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dancoder
 */
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);
 
    Long insert(UserDO userDO);
}
