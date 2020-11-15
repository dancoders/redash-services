package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class DataSourceDO {
    private Long id;
    private Long orgId;
    private String name;
    private String type;
    private String queueName;
    private String scheduledQueueName;
    private Object options;
    private Timestamp createdAt;
}
