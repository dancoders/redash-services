package com.dancoder.redash.dao.dataobject;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class DataSourceGroupDO {
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private boolean viewOnly;
}
