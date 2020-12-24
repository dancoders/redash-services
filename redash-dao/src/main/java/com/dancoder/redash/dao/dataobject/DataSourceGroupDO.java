package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dancoder
 */
@Data
@Table(name = "data_source_groups")
public class DataSourceGroupDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private boolean viewOnly;
}
