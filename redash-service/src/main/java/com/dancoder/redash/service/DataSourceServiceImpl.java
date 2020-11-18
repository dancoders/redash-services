package com.dancoder.redash.service;

import com.dancoder.redash.api.DataSourceService;
import com.dancoder.redash.api.model.DataSourceModel;
import com.dancoder.redash.business.enums.QueryRunner;
import com.dancoder.redash.business.queryrunner.AbstractQueryStrategy;
import com.dancoder.redash.dao.dataobject.DataSourceDO;
import com.dancoder.redash.dao.mapper.DataSourceMapper;
import com.dancoder.redash.dao.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dancoder
 */
@Component
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    private static final BeanCopier COPIER = BeanCopier.create(
            DataSourceDO.class, DataSourceModel.class, false
    );

    @Override
    public List<DataSourceModel> getList() {
        // 模拟当前用户groupId = 1 admin权限组 TODO
        Long groupId = 1L;
        // 组装dataSourceModel
        List<DataSourceDO> dataSources = dataSourceMapper.findDataSourcesByCondition(groupId);

        List<DataSourceModel> ret = new LinkedList<>();
        for (DataSourceDO dataSource : dataSources) {
            DataSourceModel model = new DataSourceModel();

            AbstractQueryStrategy queryRunner = QueryRunner.
                    getQueryStrategyByType(dataSource.getType());

            dataSource.getOptions();

            model.setSyntax(queryRunner.getSyntax());
            model.setPaused(0);
            model.setPause_reason("");

            COPIER.copy(dataSource, model, null);
            ret.add(model);
        }
        return ret;
    }
}
