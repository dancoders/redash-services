package com.redash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("query_results")
public class QueryResultDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long dataSourceId;
    private String queryHash;
    private String query;
    private String data;
    private Double runtime;
    private Timestamp retrievedAt;
}
