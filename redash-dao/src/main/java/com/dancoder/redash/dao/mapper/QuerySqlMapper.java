package com.dancoder.redash.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    @Select({"${sql}"})
    @ResultType(List.class)
    List<LinkedHashMap<String, Object>> customQuery(@Param("sql") String sql);
}
