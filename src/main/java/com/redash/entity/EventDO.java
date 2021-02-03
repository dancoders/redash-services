package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("events")
public class EventDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long userId;
    private String action;
    private String ObjectType;
    private String objectId;
    private String additionalProperties;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
