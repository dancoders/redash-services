package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class VisualizationModel {
    private Long id;
    private Long queryId;
    private String type;
    private String name;
    private String description;
    private String options;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
