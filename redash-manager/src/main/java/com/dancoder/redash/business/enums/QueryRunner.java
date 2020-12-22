package com.dancoder.redash.business.enums;

import com.dancoder.redash.business.queryrunner.AbstractQueryStrategy;
import com.dancoder.redash.business.queryrunner.MysqlQueryStrategy;
import com.dancoder.redash.business.queryrunner.GreenPlumQueryStrategy;

/**
 * @author dancoder
 */

public enum QueryRunner {

    /**
     * mysql
     */
    MYSQL("mysql", new MysqlQueryStrategy()),

    /**
     * postgres
     */
    PG("postgres", new GreenPlumQueryStrategy());

    private final String type;

    private final AbstractQueryStrategy queryStrategy;

    QueryRunner(String type, AbstractQueryStrategy queryStrategy) {
        this.type = type;
        this.queryStrategy = queryStrategy;
    }

    public String getType() {
        return type;
    }

    public AbstractQueryStrategy getQueryStrategy() {
        return queryStrategy;
    }

    public static QueryRunner getQueryRunnerByType(String type) {
        for (QueryRunner queryRunner : values()) {
            if (type.equals(queryRunner.getType())) {
                return queryRunner;
            }
        }
        return null;
    }

    public static AbstractQueryStrategy getQueryStrategyByType(String type) {
        for (QueryRunner queryRunner : values()) {
            if (type.equals(queryRunner.getType())) {
                return queryRunner.getQueryStrategy();
            }
        }
        return null;
    }
}