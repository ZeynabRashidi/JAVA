package com.base.handlers;

import com.base.domain.BaseAggregateRoot;

public interface EventSouringHandler<T> {
    void  save(BaseAggregateRoot root);
     T getById(String id);

}
