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
@Table(name = "notification_destinations")
public class NotificationDestinationDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private Long userId;
    private String type;
    private String name;
    private String options;
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
}
