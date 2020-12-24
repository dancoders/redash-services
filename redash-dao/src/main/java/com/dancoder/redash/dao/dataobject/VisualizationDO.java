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
@Table(name = "visualizations")
public class VisualizationDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long queryId;
    private String type;
    private String name;
    private String description;
    private String options;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
