package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class AlertSubscriptionDTO {
    private Long id;
    private Long userId;
    private Long alertId;
    private Long destinationId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
