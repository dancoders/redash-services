package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QueryResultModel {
    private Long id;
    private Long orgId;
    private Long dataSourceId;
    private String queryHash;
    private String query;
    private String data;
    private Double runtime;
    private Timestamp retrievedAt;
}
