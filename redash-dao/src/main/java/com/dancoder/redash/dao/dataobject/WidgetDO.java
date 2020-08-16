package com.dancoder.redash.dao.dataobject;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author dancoder
 */
@Data
public class WidgetDO {
    private Long id;
    private Long visualizationId;
    private String text;
    private Long width;
    private String options;
    private Long dashboardsId;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}