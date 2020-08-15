package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class EventModel {
    private Long id;
    private Long orgId;
    private Long userId;
    private String action;
    private String ObjectType;
    private String objectId;
    private String additionalProperties;
    private Timestamp createdAt;
}
