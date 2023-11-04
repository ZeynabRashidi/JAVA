package com.cbs.framework.annoatation.procces;


import com.cbs.framework.annoatation.AggregateRoot;
import com.cbs.framework.domain.BaseAggregateRoot;
import com.cbs.framework.exception.DomainException;
import com.cbs.framework.util.AnnotationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

/**
 * @author : Z_Rashidi
 * @author b_aliaskari
 */

public class ProcessingAnnotations {
    private final Logger logger = LogManager.getLogger(ProcessingAnnotations.class.getName());
    private static final String BASE_PACKAGE = "com.isc.cbs";

    public static void main(String[] args) {
        ProcessingAnnotations processingAnnotations = new ProcessingAnnotations();
        processingAnnotations.checkAggregateRootes();
    }


    private void checkAggregateRootes() {
        Set<Class<?>> classes = AnnotationUtils.findAllClasses(BASE_PACKAGE);
        List<Class<?>> aggregateRootListClasses = classes.stream()
                .filter(aClass -> aClass.isAnnotationPresent(AggregateRoot.class)).toList();

        for (Class<?> clazz : aggregateRootListClasses) {
            if (!BaseAggregateRoot.class.isAssignableFrom(clazz)) {
                logger.info("{} with @AggregateRoot didn't extend necessary class!", clazz.getSimpleName());
                throw new DomainException(clazz.getSimpleName() + " with @AggregateRoot didn't extend necessary class!");
            }
        }
    }
}
