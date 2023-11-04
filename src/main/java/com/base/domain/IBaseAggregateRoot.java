package com.base.domain;


import com.base.event.BaseEvent;

import java.io.Serializable;
import java.util.List;

/**
 * Dedicated entity of a group of entities (The group is called "Aggregate") that guarantees the consistency of changes being made within
 * the group by forbidding external objects from holding direct references to its members.
 *
 * @param <T> Type of the aggregate root identifier.
 */
public interface IBaseAggregateRoot<T extends Serializable> extends IBaseEntity<T> {

    /**
     * Returns the unique aggregate root identifier.
     *
     * @return Identifier.
     */
    @Override
     T getIdentifier();

    /**
     * Returns a list of uncommitted changes.
     *
     * @return List of events that were not persisted yet.
     */
     List<BaseEvent> getUncommittedChanges();

    /**
     * Returns the information if the aggregate has uncommited changes.
     *
     * @return TRUE if the aggregate will return a non-empty list for {@link #getUncommittedChanges()}, else FALSE.
     */
     boolean hasUncommitedChanges();

    /**
     * Clears the internal change list and sets the new version number.
     */
     void markChangesAsCommitted();

    /**
     * Returns the current version of the aggregate.
     *
     * @return Current version that does NOT included uncommitted changes.
     */
    public int getVersion();


    /**
     * Set current state version of the aggregate
     * @param version
     */
    void setVersion(int version);

    /**
     * raise new event on aggregate
     * @param event
     */

    void raiseEvent(BaseEvent event);

    void replayEvent(Iterable<BaseEvent> events);




}
