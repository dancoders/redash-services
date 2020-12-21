package com.dancoder.redash.framework.handle.provider;


import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.provider.AbstractDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractMyDataSourceProvider extends AbstractDataSourceProvider {
    private static final Logger log = LoggerFactory.getLogger(com.baomidou.dynamic.datasource.provider.AbstractDataSourceProvider.class);
    @Autowired
    private DataSourceCreator dataSourceCreator;

    public AbstractMyDataSourceProvider() {
    }

    @Override
    protected Map<String, DataSource> createDataSourceMap(Map<String, DataSourceProperty> dataSourcePropertiesMap) {
        Map<String, DataSource> dataSourceMap = new HashMap(dataSourcePropertiesMap.size() * 2);
        Iterator var3 = dataSourcePropertiesMap.entrySet().iterator();

        while(var3.hasNext()) {
            Entry<String, DataSourceProperty> item = (Entry)var3.next();
            DataSourceProperty dataSourceProperty = (DataSourceProperty)item.getValue();
            String poolName = dataSourceProperty.getPoolName();
            if (poolName == null || "".equals(poolName)) {
                poolName = (String)item.getKey();
            }

            dataSourceProperty.setPoolName(poolName);

            DataSource dataSource = null;
            try {
                dataSource = this.dataSourceCreator.createDataSource(dataSourceProperty);
            } catch (Exception e) {
                continue;
            }
            dataSourceMap.put(poolName, dataSource);
        }

        return dataSourceMap;
    }
}

