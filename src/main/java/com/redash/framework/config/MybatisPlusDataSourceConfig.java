package com.redash.framework.config;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.redash.business.enums.QueryRunner;
import com.redash.framework.handle.provider.AbstractMyJdbcDataSourceProvider;
import com.redash.queryrunner.AbstractQueryStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * @author dancoder
 */
@Configuration
public class MybatisPlusDataSourceConfig {
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        return interceptor;
    }

    /**
     * 配置文件数据的松散绑定
     */
    @Resource
    private DynamicDataSourceProperties properties;

    /**
     * map驼峰下划线转换
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
    }

    @Bean
    public DynamicDataSourceProvider dynamicDataSourceProvider() {
        DataSourceProperty property = properties.getDatasource().get(properties.getPrimary());
        return new AbstractMyJdbcDataSourceProvider(property.getDriverClassName(), property.getUrl(), property.getUsername(), property.getPassword()) {
            @Override
            protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
                String sql = "select id,name,type,\"options\" FROM data_sources";
                ResultSet rs = statement.executeQuery(sql);

                Map<String, DataSourceProperty> map = properties.getDatasource();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    String options = rs.getString("options");
                    JSONObject option = JSONObject.parseObject(options);

                    String host = option.getString("host");
                    String dbName = option.getString("db");
                    String userName = option.getString("user");
                    String password = option.getString("passwd");
                    String port = option.getString("port");
//                    {"db":"dblog_test","host":"localhost","passwd":"--------","port":3306,"user":"root"}

                    AbstractQueryStrategy queryStrategy = QueryRunner.getQueryStrategyByType(type);
                    String jdbcUrl = queryStrategy.getJdbcUrl(host, port, dbName);

                    DataSourceProperty property = new DataSourceProperty();
                    property.setDriverClassName(queryStrategy.getDriverName());
                    property.setUrl(jdbcUrl);
                    property.setUsername(userName);
                    property.setPassword(password);
                    map.put(name, property);
                }
                return map;
            }
        };
    }
}
