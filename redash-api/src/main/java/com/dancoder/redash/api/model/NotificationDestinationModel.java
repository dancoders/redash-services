package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class NotificationDestinationModel {
    private Long id;
    private Long orgId;
    private Long userId;
    private String type;
    private String name;
    private String options;
    private Timestamp createdAt;
}
