package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@Table(name = "data_sources")
public class DataSourceDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orgId;
    private String name;
    private String type;
    private String queueName;
    private String scheduledQueueName;
    private Object options;
    private Timestamp createdAt;
}
