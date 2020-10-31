package com.dancoder.redash.dao.mapper;

import com.dancoder.redash.dao.dataobject.GroupDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface GroupMapper {

    List<GroupDO> getAll();

    GroupDO getById(Long id);
}
