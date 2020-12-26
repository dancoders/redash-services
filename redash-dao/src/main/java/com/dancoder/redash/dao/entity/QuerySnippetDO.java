package com.dancoder.redash.dao.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@Table(name = "query_snippets")
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
