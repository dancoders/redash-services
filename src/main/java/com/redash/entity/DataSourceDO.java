package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("data_sources")
public class DataSourceDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private String name;
    private String type;
    private String queueName;
    private String scheduledQueueName;
    private Object options;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
