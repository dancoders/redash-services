package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("changes")
public class ChangeDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long objectVersion;
    private Long userId;
    private Long objectId;
    private String objectType;
    private String change;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
