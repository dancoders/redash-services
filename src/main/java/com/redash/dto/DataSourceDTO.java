package com.redash.dto;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class DataSourceDTO {
    private Long id;
    private String name;
    private String pause_reason;
    private Integer paused;
    private String syntax;
    private String type;
    private boolean view_only;
}
