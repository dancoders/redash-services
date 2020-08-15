package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class GroupModel {
    private Long id;
    private Long orgId;
    private String type;
    private String name;
    private String permissions;
    private Timestamp createdAt;
}
