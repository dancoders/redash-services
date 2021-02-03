package com.redash.dto;

import lombok.Data;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * @author dancoder
 */
@Data
public class UserDTO {
    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;
    private List<GroupDTO> groups;
    private String apiKey;
    private Date disabledAt;
    private JSONObject details;
    private Date createdAt;
    private Date updatedAt;

    // PG json 使用model、mapper、以及数据操作时的写法：https://blog.csdn.net/weixin_42800689/article/details/91413254
}