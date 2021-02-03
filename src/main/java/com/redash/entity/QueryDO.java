package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("queries")
public class QueryDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long version;
    private Long orgId;
    private Long dataSourceId;
    private Long latestQueryDataId;
    private String name;
    private String description;
    private String query;
    private String queryHash;
    private String apiKey;
    private Long userId;
    private Long lastModifiedById;
    private boolean isArchived;
    private boolean isDraft;
    private String schedule;
    private Long scheduleFailures;
    private String options;
    private Object searchVector;
    private String tags;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
