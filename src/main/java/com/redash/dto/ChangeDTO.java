package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class ChangeDTO {
    private Long id;
    private Long objectVersion;
    private Long userId;
    private Long objectId;
    private String objectType;
    private String change;
    private Timestamp createdAt;
}
