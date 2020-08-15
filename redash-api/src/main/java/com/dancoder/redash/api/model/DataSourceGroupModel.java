package com.dancoder.redash.api.model;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class DataSourceGroupModel {
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private boolean viewOnly;
}
