package com.dancoder.redash.api.model;

import lombok.Data;
import org.json.simple.JSONObject;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
public class UserModel {
    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;
    private Long groups;
    private String apiKey;
    private Date disabledAt;
    private JSONObject details;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}