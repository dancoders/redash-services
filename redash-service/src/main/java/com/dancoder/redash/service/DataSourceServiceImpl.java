package com.dancoder.redash.service;

import cn.hutool.json.JSONObject;
import com.dancoder.redash.api.DataSourceService;
import com.dancoder.redash.api.model.DataSourceModel;
import com.dancoder.redash.dao.dataobject.GroupDO;
import com.dancoder.redash.dao.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<DataSourceModel> getList() {
        // TODO 判断权限，如果是admin，则返回全部；如果不是，则根据group返回对应的dataSource
        List<GroupDO> dataSources = groupMapper.getAll();

        for (GroupDO groupDO : dataSources) {
            JSONObject groupJSON = new JSONObject(groupDO);
            // view_all 根据ds的groupid 和当前用户的group 判断是否有权限查看改ds
            groupJSON.set("view_all",null);
        }

        return null;
    }
}
