package com.redash.framework.object;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dancoder
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseConditionVO {
    public final static int DEFAULT_PAGE_SIZE = 10;
    private int page = 1;
    private int pageSize = 0;
    private String order;

    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }
}
