package com.base.inferstructure;

import com.base.domain.BaseEntityObject;
import com.base.queries.BaseQuery;
import com.base.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {

    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntityObject> List<U> send(BaseQuery query);
}
