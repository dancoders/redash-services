package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("groups")
public class GroupDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private String type;
    private String name;
    private String[] permissions;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
