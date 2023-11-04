package com.base.queries;


import com.base.domain.BaseEntityObject;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends  BaseQuery> {

    List<BaseEntityObject> handle(T query);
}
