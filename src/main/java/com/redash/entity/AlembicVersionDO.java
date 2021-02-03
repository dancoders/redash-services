package com.redash.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author dancoder
 */
@Data
@TableName("alembic_version")
public class AlembicVersionDO {
    private String versionNum;
}
