package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("query_snippets")
public class QuerySnippetDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long userId;
    private String trigger;
    private String description;
    private String snippet;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
