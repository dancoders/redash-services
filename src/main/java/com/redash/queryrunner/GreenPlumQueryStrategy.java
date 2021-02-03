package com.redash.queryrunner;

/**
 * @author dancoder
 */
public class GreenPlumQueryStrategy extends AbstractQueryStrategy {

    @Override
    public String getSyntax() {
        return "sql";
    }

    @Override
    public String getDriverName() {
        return "com.pivotal.jdbc.GreenplumDriver";
    }

    @Override
    public String getTables(int dataSourceId) {
        StringBuffer sbSql = new StringBuffer()
                .append("SELECT s.nspname as table_schema,c.relname as table_name,a.attname as column_name")
                .append("FROM pg_class c JOIN pg_namespace s ON c.relnamespace = s.oid")
                .append("AND s.nspname NOT IN ('pg_catalog', 'information_schema')")
                .append("JOIN pg_attribute a ON a.attrelid = c.oid AND a.attnum > 0")
                .append("AND NOT a.attisdropped WHERE c.relkind IN ('m', 'f', 'p')")
                .append("UNION")
                .append("SELECT table_schema,table_name,column_name FROM information_schema.columns")
                .append("WHERE table_schema NOT IN ('pg_catalog', 'information_schema')");
        return sbSql.toString();
    }

    @Override
    public String getJdbcUrl(String ip, String port, String dbName) {
        return "jdbc:pivotal:greenplum://" + ip + ":" + port + ";DatabaseName=" + dbName;
    }
}
