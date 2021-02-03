package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("alert_subscriptions")
public class AlertSubscriptionDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long alertId;
    private Long destinationId;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
}
