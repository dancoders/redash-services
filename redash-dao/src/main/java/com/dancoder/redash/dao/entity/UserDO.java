package com.dancoder.redash.dao.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.sql.Timestamp;

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
    private Integer[] groups;
    private String apiKey;
    private Timestamp disabledAt;
    private Object details;

    @TableField(fill = FieldFill.INSERT)
    private Timestamp createdAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updatedAt;

    // PG json 使用model、mapper、以及数据操作时的写法：https://blog.csdn.net/weixin_42800689/article/details/91413254

    // https://www.cnblogs.com/kylindai/p/3563818.html
}
