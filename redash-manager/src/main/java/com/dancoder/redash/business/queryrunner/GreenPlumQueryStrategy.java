package com.dancoder.redash.business.queryrunner;

import cn.hutool.json.JSONObject;

import java.sql.*;

/**
 * @author dancoder
 */
public class GreenPlumQueryStrategy extends AbstractQueryStrategy{

    private final static String DRIVER_NAME = "com.pivotal.jdbc.GreenplumDriver";

    @Override
    public String getSyntax() {
        return "sql";
    }

    @Override
    public String getType() {
        return "postgres";
    }

    @Override
    public JSONObject getTables(int dataSourceId) {
        return null;
    }

    @Override
    public String getJdbcUrl(String ip, String port, String dbName) {
        return "jdbc:pivotal:greenplum://" + ip + ":" + port + ";DatabaseName=" + dbName;
    }

    @Override
    public Connection getConnection(String jdbcUrl, String userName, String password) throws SQLException {
        return null;
    }

    @Override
    public ResultSet executeSql(Connection conn, String sql) {
        return null;
    }

}
