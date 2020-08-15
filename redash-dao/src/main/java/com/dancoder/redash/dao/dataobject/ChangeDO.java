package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class ChangesDO {
    private Long id;
    private Long objectVersion;
    private Long userId;
    private Long objectId;
    private String objectType;
    private String change;
    private Timestamp createdAt;
}
