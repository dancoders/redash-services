package com.dancoder.redash.dao.dataobject;

import lombok.Data;
import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class DashboardDO {
    private Long id;
    private Long version;
    private Long orgId;
    private Long userId;
    private String slug;
    private String name;
    private String layout;
    private String tags;
    private boolean dashboardFiltersEnabled;
    private boolean isArchived;
    private boolean isDraft;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
