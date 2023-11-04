package com.cbs.framework.queries;


import com.cbs.framework.domain.BaseEntityObject;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends  BaseQuery> {

    List<BaseEntityObject> handle(T query);
}
