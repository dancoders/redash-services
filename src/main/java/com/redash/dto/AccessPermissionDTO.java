package com.redash.dto;

import lombok.Data;

/**
 * @author dancoder
 */
@Data
public class AccessPermissionDTO {
    private Long id;
    private Long grantorId;
    private Long granteeId;
    private Long objectId;
    private String objectType;
    private String accessType;
}
