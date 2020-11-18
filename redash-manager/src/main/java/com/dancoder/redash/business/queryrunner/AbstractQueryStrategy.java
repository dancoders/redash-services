package com.dancoder.redash.business.queryrunner;

import cn.hutool.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dancoder
 */
public abstract class AbstractQueryStrategy {

    /**
     * 获取该查询模式的结构类型
     * @return
     */
    public abstract String getSyntax();

    /**
     * 获取该查询模式的类型
     * @return
     */
    public abstract String getType();

    /**
     * 获取表列表、结构
     * @param dataSourceId 数据源id
     * @return
     */
    public abstract JSONObject getTables(int dataSourceId);

    /**
     * 获取jdbcUrl
     * @param ip
     * @param port
     * @param dbName
     * @return
     */
    public abstract String getJdbcUrl(String ip, String port, String dbName);

    /**
     * 获取数据源
     * @param jdbcUrl jdbcurl
     * @param userName 用户名
     * @param password 密码
     * @return
     * @throws SQLException
     */
    public abstract Connection getConnection(String jdbcUrl, String userName, String password) throws SQLException;

    /**
     * 执行sql
     * @param conn
     * @param sql
     * @return
     */
    public abstract ResultSet executeSql(Connection conn, String sql);
}
