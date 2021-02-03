package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@TableName("widgets")
public class WidgetDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long visualizationId;
    private String text;
    private Long width;
    private String options;
    private Long dashboardsId;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;


}