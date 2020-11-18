package com.dancoder.redash.business.queryrunner;

import cn.hutool.json.JSONObject;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

/**
 * @author dancoder
 */
public class MysqlQueryStrategy extends AbstractQueryStrategy{

    private static final Log logger = LogFactory.get();

    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

    @Override
    public String getSyntax() {
        return "sql";
    }

    @Override
    public String getType() {
        return "mysql";
    }

    @Override
    public JSONObject getTables(int dataSourceId) {
        StringBuffer sbSql = new StringBuffer()
                .append("SELECT col.table_schema as table_schema,")
                .append("col.table_name as table_name,")
                .append("col.column_name as column_name")
                .append("FROM `information_schema`.`columns` col")
                .append("WHERE col.table_schema NOT IN")
                .append("('information_schema', 'performance_schema', 'mysql', 'sys');");

        // TODO executeSql
        return null;
    }

    @Override
    public String getJdbcUrl(String ip, String port, String dbName) {
        return "jdbc:mysql://" + ip + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
    }

    @Override
    public Connection getConnection(String jdbcUrl, String userName, String password) throws SQLException {
        Connection conn = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (Exception e) {
            logger.info("mysql 连接失败", e);
        }

        return conn;
    }

    @Override
    public ResultSet executeSql(Connection conn, String sql) {
        ResultSet resultSet = null;
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.getResultSet();
        } catch (SQLException e) {
            logger.info("执行sql 失败", e);
        }

        return resultSet;
    }

}