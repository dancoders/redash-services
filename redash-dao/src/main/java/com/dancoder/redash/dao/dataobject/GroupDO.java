package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class GroupDO {
    private Long id;
    private Long orgId;
    private String type;
    private String name;
    private String permissions;
    private Timestamp createdAt;
}
