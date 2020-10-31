package com.dancoder.redash.api.model;

import lombok.Data;
import org.json.simple.JSONObject;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author dancoder
 */
@Data
public class UserModel {
    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;
    private List groups;
    private String apiKey;
    private Date disabledAt;
    private JSONObject details;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // PG json 使用model、mapper、以及数据操作时的写法：https://blog.csdn.net/weixin_42800689/article/details/91413254
}