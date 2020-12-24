package com.dancoder.redash.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.dao.dataobject.ChangeDO;
import com.dancoder.redash.dao.dataobject.DataSourceDO;
import com.dancoder.redash.dao.dataobject.UserDO;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dancoder
 */
public interface DataSourceMapper extends BaseMapper<DataSourceDO> {
    List<DataSourceDO> findDataSourcesByCondition(Long groupId);
}
