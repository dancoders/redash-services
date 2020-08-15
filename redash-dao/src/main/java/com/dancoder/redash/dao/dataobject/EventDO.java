package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class EventDO {
    private Long id;
    private Long orgId;
    private Long userId;
    private String action;
    private String ObjectType;
    private String objectId;
    private String additionalProperties;
    private Timestamp createdAt;
}
