package com.redash.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redash.business.enums.QueryRunner;
import com.redash.dto.DataSourceDTO;
import com.redash.entity.DataSourceDO;
import com.redash.mapper.DataSourceMapper;
import com.redash.mapper.QuerySqlMapper;
import com.redash.queryrunner.AbstractQueryStrategy;
import com.redash.service.DataSourceService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dancoder
 */
@Service
public class DataSourceServiceImpl extends ServiceImpl<DataSourceMapper,DataSourceDO> implements DataSourceService {

//    private final QuerySqlMapper querySqlMapper;
//
//    public DataSourceServiceImpl(QuerySqlMapper querySqlMapper) {
//        this.querySqlMapper = querySqlMapper;
//    }

    private static final BeanCopier COPIER = BeanCopier.create(
            DataSourceDO.class, DataSourceDTO.class, false
    );

    @Override
    public List<DataSourceDTO> getList() {
        // TODO test

//        DynamicDataSourceContextHolder.push("test");
//        String sql = "select * from biz_article;";
//        List<LinkedHashMap<String, Object>> linkedHashMaps = querySqlMapper.customQuery(sql);

        // 模拟当前用户groupId = 1 admin权限组 TODO
        Long groupId = 1L;
        // 组装dataSourceModel
        List<DataSourceDO> dataSources = baseMapper.findDataSourcesByCondition(groupId);

        List<DataSourceDTO> ret = new LinkedList<>();
        for (DataSourceDO dataSource : dataSources) {
            DataSourceDTO model = new DataSourceDTO();

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
