package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class VisualizationDO {
    private Long id;
    private Long queryId;
    private String type;
    private String name;
    private String description;
    private String options;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
