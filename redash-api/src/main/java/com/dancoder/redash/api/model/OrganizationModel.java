package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class OrganizationModel {
    private Long id;
    private String name;
    private String slug;
    private String settings;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
