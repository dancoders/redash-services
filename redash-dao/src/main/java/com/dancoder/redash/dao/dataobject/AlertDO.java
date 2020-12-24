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
@Table(name = "alerts")
public class AlertDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long queryId;
    private Long userId;
    private Long rearm;
    private String name;
    private String options;
    private String state;
    private Timestamp lastTriggeredAt;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
