package com.dancoder.redash.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dancoder.redash.dao.dataobject.GroupDO;

import java.util.List;

public interface GroupMapper extends BaseMapper<GroupDO> {

    List<GroupDO> getAll();

    GroupDO getById(Long id);
}
