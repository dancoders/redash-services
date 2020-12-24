package com.dancoder.redash.api;

import com.dancoder.redash.api.model.DataSourceModel;

import java.util.List;

public interface DataSourceService {

    /**
     * 获取数据源列表
     * @return
     */
    List<DataSourceModel> getList();
}
