package com.dancoder.redash.api.model;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QueryModel {
    private Timestamp updatedAt;
    private Timestamp createdAt;
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
}
