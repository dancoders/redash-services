package com.redash.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author dancoder
 */
@Data
@TableName("access_permissions")
public class AccessPermissionDO {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long grantorId;
    private Long granteeId;
    private Long objectId;
    private String objectType;
    private String accessType;
}
