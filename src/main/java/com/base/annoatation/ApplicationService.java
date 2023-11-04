package com.base.annoatation;

import java.lang.annotation.*;

/**
 * Marker annotation for application services.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationService {
}
