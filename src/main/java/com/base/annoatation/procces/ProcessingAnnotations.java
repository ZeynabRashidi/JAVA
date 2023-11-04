package com.base.annoatation.procces;


import com.base.annoatation.AggregateRoot;
import com.base.domain.BaseAggregateRoot;
import com.base.exception.DomainException;
import com.base.util.AnnotationUtils;
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
    private static final String BASE_PACKAGE = "com.cbs";

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
