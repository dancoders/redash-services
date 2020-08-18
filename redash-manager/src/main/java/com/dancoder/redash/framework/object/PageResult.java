package com.dancoder.redash.object;

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
    private Long total;
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}