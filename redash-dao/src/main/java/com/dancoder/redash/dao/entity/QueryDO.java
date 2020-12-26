package com.dancoder.redash.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@Table(name = "queries")
public class QueryDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long version;
    private Long orgId;
    private Long dataSourceId;
    private Long latestQueryDataId;
    private String name;
    private String description;
    private String query;
    private String queryHash;
    private String apiKey;
    private Long userId;
    private Long lastModifiedById;
    private boolean isArchived;
    private boolean isDraft;
    private String schedule;
    private Long scheduleFailures;
    private String options;
    private Object searchVector;
    private String tags;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
