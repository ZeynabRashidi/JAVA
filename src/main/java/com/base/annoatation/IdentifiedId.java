package com.base.annoatation;

import java.lang.annotation.*;

/**
 * Identifies a class as aggregate root
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IdentifiedId {

}
