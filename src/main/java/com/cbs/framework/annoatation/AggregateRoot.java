package com.cbs.framework.annoatation;

import java.lang.annotation.*;

/**
 * Identifies a class as aggregate root
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AggregateRoot {

}
