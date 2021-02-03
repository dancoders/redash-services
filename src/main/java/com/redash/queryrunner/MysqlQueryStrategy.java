package com.redash.queryrunner;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * @author dancoder
 */
public class MysqlQueryStrategy extends AbstractQueryStrategy {
    private static final Log logger = LogFactory.get();

    @Override
    public String getSyntax() {
        return "sql";
    }

    @Override
    public String getDriverName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public String getTables(int dataSourceId) {
        StringBuffer sbSql = new StringBuffer()
                .append("SELECT col.table_schema as table_schema,")
                .append("col.table_name as table_name,")
                .append("col.column_name as column_name")
                .append("FROM `information_schema`.`columns` col")
                .append("WHERE col.table_schema NOT IN")
                .append("('information_schema', 'performance_schema', 'mysql', 'sys');");
        return sbSql.toString();
    }

    @Override
    public String getJdbcUrl(String ip, String port, String dbName) {
        return "jdbc:mysql://" + ip + ":" + port + "/" + dbName +
                "?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8&useSSL=false";
    }
}