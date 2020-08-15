package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QueryDO {
    private Long id;
    private Long version;
    private Long orgId;
    private Long dataSourceId;
    private Long latestQueryDataId;
    private String name;
    private String description;
    private String query;
    private String queryHash;
    private String apiKey;
    private Long userId;
    private Long lastModifiedById;
    private boolean isArchived;
    private boolean isDraft;
    private String schedule;
    private Long scheduleFailures;
    private String options;
    private Object searchVector;
    private String tags;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
