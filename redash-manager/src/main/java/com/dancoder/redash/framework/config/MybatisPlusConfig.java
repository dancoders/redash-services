package com.dancoder.redash.framework.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.dancoder.redash.framework.handle.provider.AbstractMyJdbcDataSourceProvider;
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
public class MybatisPlusConfig {

    public static final String DRIVER_CLASS_NAME_MYSQL = "com.mysql.cj.jdbc.Driver";

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
                ResultSet rs = statement.executeQuery("select id,name,type,\"options\" FROM data_sources");

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

                    String url = "jdbc:"+ type +"://"+ host +":"+ port +"/" + dbName +
                            "?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&useSSL=false";

                    DataSourceProperty property = new DataSourceProperty();
                    property.setDriverClassName(DRIVER_CLASS_NAME_MYSQL);
                    property.setUrl(url);
                    property.setUsername(userName);
                    property.setPassword(password);
                    map.put(name, property);
                }
                return map;
            }
        };
    }
}
