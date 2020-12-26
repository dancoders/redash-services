package com.dancoder.redash.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author dancoder
 */
@Data
@Table(name = "data_source_groups")
public class DataSourceGroupDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private Boolean viewOnly;
}
