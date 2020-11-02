package com.dancoder.redash.api;

import com.dancoder.redash.api.model.DataSourceModel;

import java.util.List;

public interface DataSourceService {

    List<DataSourceModel> getList();
}
