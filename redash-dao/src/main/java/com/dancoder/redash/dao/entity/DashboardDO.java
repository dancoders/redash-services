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
@Table(name = "dashboards")
public class DashboardDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long version;
    private Long orgId;
    private Long userId;
    private String slug;
    private String name;
    private String layout;
    private String tags;
    private boolean dashboardFiltersEnabled;
    private boolean isArchived;
    private boolean isDraft;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateAt;
}
