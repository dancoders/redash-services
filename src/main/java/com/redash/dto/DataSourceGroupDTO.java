package com.redash.dto;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class DataSourceGroupDTO {
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private boolean viewOnly;
}
