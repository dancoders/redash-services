package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class ApiKeyDO {
    private Long id;
    private Long orgId;
    private Long objectId;
    private String objectType;
    private String apiKey;
    private boolean active;
    private Long createdById;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
