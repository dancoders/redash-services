package com.dancoder.redash.api.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author dancoder
 */
@Data
public class UserVO {

    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;
    private Integer[] groups;
    private String apiKey;
    private Date disabledAt;
    private Object details;
    private Date createdAt;
    private Date updatedAt;
    private Date activeAt;
    private String authType;
    private Boolean isDisabled;
}
