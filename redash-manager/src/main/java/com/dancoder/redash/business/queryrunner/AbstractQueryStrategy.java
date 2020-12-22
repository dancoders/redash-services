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
     * 获取该查询模式的driverName
     * @return
     */
    public abstract String getDriverName();


    /**
     * 获取表列表、结构
     * @param dataSourceId 数据源id
     * @return
     */
    public abstract String getTables(int dataSourceId);

    /**
     * 获取jdbcUrl
     * @param ip
     * @param port
     * @param dbName
     * @return
     */
    public abstract String getJdbcUrl(String ip, String port, String dbName);

}
