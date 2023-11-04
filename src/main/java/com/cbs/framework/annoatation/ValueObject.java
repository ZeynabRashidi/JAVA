package com.cbs.framework.annoatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marker annotation for Value Objects.
 * <p>
 * Value Objects may reference {@link Entity entities} and other value objects.
 */
@Target(ElementType.TYPE)
public @interface ValueObject {
}
