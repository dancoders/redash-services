package com.redash.framework.handle.provider;

import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * @author dancoder
 */
public abstract class AbstractMyJdbcDataSourceProvider extends AbstractMyDataSourceProvider implements DynamicDataSourceProvider {
    private static final Logger log = LoggerFactory.getLogger(AbstractJdbcDataSourceProvider.class);
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public AbstractMyJdbcDataSourceProvider(String url, String username, String password) {
        this((String)null, url, username, password);
    }

    public AbstractMyJdbcDataSourceProvider(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Map<String, DataSource> loadDataSources() {
        Connection conn = null;
        Statement stmt = null;

        try {
            if (!StringUtils.isEmpty(this.driverClassName)) {
                Class.forName(this.driverClassName);
                log.info("成功加载数据库驱动程序");
            }

            conn = DriverManager.getConnection(this.url, this.username, this.password);
            log.info("成功获取数据库连接" + this.url);
            stmt = conn.createStatement();
            Map<String, DataSourceProperty> dataSourcePropertiesMap = this.executeStmt(stmt);
            Map var4 = this.createDataSourceMap(dataSourcePropertiesMap);
            return var4;
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
            JdbcUtils.closeStatement(stmt);
        }

        return null;
    }

    /**
     * execute
     * @param var1
     * @return
     * @throws SQLException
     */
    protected abstract Map<String, DataSourceProperty> executeStmt(Statement var1) throws SQLException;
}
