package com.dancoder.redash.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dancoder.redash.dao.entity.DataSourceDO;

import java.util.List;

/**
 * @author dancoder
 */
public interface DataSourceMapper extends BaseMapper<DataSourceDO> {
    List<DataSourceDO> findDataSourcesByCondition(Long groupId);
}
