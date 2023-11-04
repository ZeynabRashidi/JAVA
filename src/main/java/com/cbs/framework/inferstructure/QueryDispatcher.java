package com.cbs.framework.inferstructure;

import com.cbs.framework.domain.BaseEntityObject;
import com.cbs.framework.queries.BaseQuery;
import com.cbs.framework.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {

    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntityObject> List<U> send(BaseQuery query);
}
