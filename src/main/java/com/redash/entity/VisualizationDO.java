package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("visualizations")
public class VisualizationDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long queryId;
    private String type;
    private String name;
    private String description;
    private String options;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
