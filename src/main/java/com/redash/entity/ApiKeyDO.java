package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("api_keys")
public class ApiKeyDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long objectId;
    private String objectType;
    private String apiKey;
    private boolean active;
    private Long createdById;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
}
