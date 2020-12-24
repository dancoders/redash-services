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
@Table(name = "widgets")
public class WidgetDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long visualizationId;
    private String text;
    private Long width;
    private String options;
    private Long dashboardsId;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}