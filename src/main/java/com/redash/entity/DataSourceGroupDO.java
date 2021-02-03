package com.redash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author dancoder
 */
@Data
@TableName("data_source_groups")
public class DataSourceGroupDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long dataSourceId;
    private Long groupId;
    private Boolean viewOnly;
}
