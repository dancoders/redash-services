package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class OrganizationDO {
    private Long id;
    private String name;
    private String slug;
    private String settings;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
