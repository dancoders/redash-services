package com.redash.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author dancoder
 */
@Data
@TableName(value = "users")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;

//    @ColumnType(typeHandler = com.dancoder.redash.framework.handle.mybatis.ArrayTypeHandler.class, jdbcType = JdbcType.ARRAY)
    private Integer[] groups;
    private String apiKey;
    private Date disabledAt;

//    @ColumnType(typeHandler = com.dancoder.redash.framework.handle.mybatis.JSONTypeHandler.class, jdbcType = JdbcType.JAVA_OBJECT)
    private Object details;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private Date createdAt;
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    // PG json 使用model、mapper、以及数据操作时的写法：https://blog.csdn.net/weixin_42800689/article/details/91413254

    // https://www.cnblogs.com/kylindai/p/3563818.html
}
