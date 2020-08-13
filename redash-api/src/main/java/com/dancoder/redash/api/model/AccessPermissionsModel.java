package com.dancoder.redash.api.model;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class AccessPermissionsModel {
    private Long id;
    private Long grantorId;
    private Long granteeId;
    private Long objectId;
    private String objectType;
    private String accessType;
}
