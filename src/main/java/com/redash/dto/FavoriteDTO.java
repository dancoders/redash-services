package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class FavoriteDTO {
    private Long id;
    private Long orgId;
    private Long userId;
    private Long objectId;
    private String ObjectType;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
