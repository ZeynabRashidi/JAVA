package com.base.domain;

import java.io.Serializable;

/**
 * An object that is not defined by its attributes, but rather by a thread of continuity and its identity.
 *
 * @param <T> Entity ID type.
 */
public interface IBaseEntity<T extends Serializable> {


    /**
     * Returns the unique entity identifier.
     *
     * @return Identifier.
     */
    T getIdentifier();

}
