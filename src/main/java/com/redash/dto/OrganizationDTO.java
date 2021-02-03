package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class OrganizationDTO {
    private Long id;
    private String name;
    private String slug;
    private String settings;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
