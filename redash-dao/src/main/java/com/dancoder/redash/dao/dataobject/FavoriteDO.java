package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class FavoriteDO {
    private Long id;
    private Long orgId;
    private Long userId;
    private Long objectId;
    private String ObjectType;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
