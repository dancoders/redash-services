package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("dashboards")
public class DashboardDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long version;
    private Long orgId;
    private Long userId;
    private String slug;
    private String name;
    private String layout;
    private String tags;
    private boolean dashboardFiltersEnabled;
    private boolean isArchived;
    private boolean isDraft;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateAt;
}
