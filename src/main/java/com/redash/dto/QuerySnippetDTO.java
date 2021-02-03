package com.redash.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class QuerySnippetDTO {
    private Long id;
    private Long orgId;
    private Long userId;
    private String trigger;
    private String description;
    private String snippet;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
