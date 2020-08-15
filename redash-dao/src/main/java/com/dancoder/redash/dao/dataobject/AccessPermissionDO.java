package com.dancoder.redash.dao.dataobject;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class AccessPermissionDO {
    private Long id;
    private Long grantorId;
    private Long granteeId;
    private Long objectId;
    private String objectType;
    private String accessType;
}
