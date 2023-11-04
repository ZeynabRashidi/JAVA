package com.base.annoatation.config;

import com.base.annoatation.AggregateRoot;
import com.base.annoatation.CommandHandler;
import com.base.annoatation.sample.SampleAnnotatedClass;
import com.base.util.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author B_Aliaskari
 * @author Z_RASHIDI
 */
//@Configuration
public class CommandHandlerProcess {
    private static final String BASE_PACKAGE = "com.base";

   // @EventListener(ApplicationReadyEvent.class)
   // @Bean
    public void doSomethingAfterStartup() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Set<Class<?>> aggregateClasses = AnnotationUtils.findAnnotatedClasses(BASE_PACKAGE, AggregateRoot.class);
        for (Class<?> aggregateClass : aggregateClasses) {
            Method[] methods = aggregateClass.getMethods();
            for (Method method : methods) {
                boolean present = AnnotationUtils.isAnnotationPresent(method, CommandHandler.class);
                if (present){
                    method.invoke(aggregateClass.newInstance());
                }
            }
        }

    }
public  void test() throws InvocationTargetException, IllegalAccessException {
    Method[] methods = SampleAnnotatedClass.class.getMethods();
    SampleAnnotatedClass sampleObject = new SampleAnnotatedClass();
       methods[1].invoke(sampleObject, "data");
    System.out.println(methods[1].invoke(sampleObject));
}

}
