package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class GroupDTO {
    private Long id;
    private Long orgId;
    private String type;
    private String name;
    private String permissions;
    private Timestamp createdAt;
}
