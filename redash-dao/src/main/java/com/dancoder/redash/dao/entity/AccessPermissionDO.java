package com.dancoder.redash.dao.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dancoder
 */
@Data
@Table(name = "access_permissions")
public class AccessPermissionDO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long grantorId;
    private Long granteeId;
    private Long objectId;
    private String objectType;
    private String accessType;
}
