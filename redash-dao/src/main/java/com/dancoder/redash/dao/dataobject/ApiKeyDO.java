package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
@Table(name = "api_keys")
public class ApiKeyDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orgId;
    private Long objectId;
    private String objectType;
    private String apiKey;
    private boolean active;
    private Long createdById;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
