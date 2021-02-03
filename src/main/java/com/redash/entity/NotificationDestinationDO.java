package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("notification_destinations")
public class NotificationDestinationDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long userId;
    private String type;
    private String name;
    private String options;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
