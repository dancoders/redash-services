package com.redash.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.redash.dto.DataSourceDTO;
import com.redash.entity.DataSourceDO;

import java.util.List;

public interface DataSourceService extends IService<DataSourceDO> {

    /**
     * 获取数据源列表
     * @return
     */
    List<DataSourceDTO> getList();
}
