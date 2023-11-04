package com.base.annoatation;

import java.lang.annotation.*;

/**
 * Marker annotation for domain services.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
}
