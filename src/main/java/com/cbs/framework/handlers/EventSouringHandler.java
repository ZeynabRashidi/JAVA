package com.cbs.framework.handlers;

import com.cbs.framework.domain.BaseAggregateRoot;

public interface EventSouringHandler<T> {
    void  save(BaseAggregateRoot root);
     T getById(String id);

}
