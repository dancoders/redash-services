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
@Table(name = "groups")
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
