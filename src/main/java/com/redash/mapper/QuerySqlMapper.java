package com.redash.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 自定义查询
 * @author dancoder
 */
public interface QuerySqlMapper {

    /**
     * 自定义查询
     * @param sql
     * @return
     */
    List<LinkedHashMap<String, Object>> customQuery(@Param("sql") String sql);
}
