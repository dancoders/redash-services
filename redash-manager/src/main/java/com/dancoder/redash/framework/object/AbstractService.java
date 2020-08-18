package com.dancoder.redash.framework.object;

import java.util.List;

/**
 * @author dancoder
 */
public interface AbstractService<T, PK> {

    T insert(T entity);

    default void insertList(List<T> entities) {

    }

    boolean removeByPrimaryKey(PK primaryKey);

    boolean updateSelective(T entity);

    T getByPrimaryKey(PK primaryKey);

    default List<T> listAll() {
        return null;
    }
}