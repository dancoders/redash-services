package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QueryResultDO {
    private Long id;
    private Long orgId;
    private Long dataSourceId;
    private String queryHash;
    private String query;
    private String data;
    private Double runtime;
    private Timestamp retrievedAt;
}
