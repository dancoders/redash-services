package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class ChangesModel {
    private Long id;
    private Long objectVersion;
    private Long userId;
    private Long objectId;
    private String objectType;
    private String change;
    private Timestamp createdAt;
}
