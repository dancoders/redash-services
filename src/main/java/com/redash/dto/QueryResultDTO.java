package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QueryResultDTO {
    private Long id;
    private Long orgId;
    private Long dataSourceId;
    private String queryHash;
    private String query;
    private String data;
    private Double runtime;
    private Timestamp retrievedAt;
}
