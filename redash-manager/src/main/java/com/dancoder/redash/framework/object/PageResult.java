package com.dancoder.redash.framework.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * bootstrap table用到的返回json格式
 * @author dancoder
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult {
    private Integer count;
    private Integer page;
    private Integer pageSize;
    private List results;

    public PageResult(Integer count, Integer page, Integer pageSize, List results) {
        this.count = count;
        this.page = page;
        this.pageSize = pageSize;
        this.results = results;
    }

    public PageResult() {
    }
}