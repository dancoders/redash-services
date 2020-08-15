package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class AlertDO {
    private Long id;
    private Long queryId;
    private Long userId;
    private Long rearm;
    private String name;
    private String options;
    private String state;
    private Timestamp lastTriggeredAt;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
