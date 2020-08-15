package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class DataSourceModel {
    private Long id;
    private Long orgId;
    private String name;
    private String type;
    private String queueName;
    private String scheduledQueueName;
    private byte encryptedOptions;
    private Timestamp createdAt;
}
