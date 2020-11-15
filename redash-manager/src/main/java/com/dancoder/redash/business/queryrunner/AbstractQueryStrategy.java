package com.dancoder.redash.business.queryrunner;

import cn.hutool.json.JSONObject;

/**
 * @author dancoder
 */
public abstract class AbstractQueryStrategy {

    /**
     * 获取该查询模式的结构类型
     * @return
     */
    public abstract String getSyntax();

    /**
     * 获取该查询模式的类型
     * @return
     */
    public abstract String getType();

    /**
     * 获取表列表、结构
     * @return
     */
    public abstract JSONObject getTables();


    // getConnection

    // ...
}
