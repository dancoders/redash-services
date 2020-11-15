package com.dancoder.redash.api.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class DataSourceModel {
    private Long id;
    private String name;
    private String pause_reason;
    private Integer paused;
    private String syntax;
    private String type;
    private boolean view_only;
}
