package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class AlertSubscriptionModel {
    private Long id;
    private Long userId;
    private Long alertId;
    private Long destinationId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
