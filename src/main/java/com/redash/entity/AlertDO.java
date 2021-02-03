package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("alerts")
public class AlertDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long queryId;
    private Long userId;
    private Long rearm;
    private String name;
    private String options;
    private String state;
    private Timestamp lastTriggeredAt;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateAt;
}
