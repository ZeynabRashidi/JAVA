package com.base.annoatation.config;


import com.base.annoatation.InterfaceCommandHandler;
import com.base.command.CommandHandlerMethod;
import com.base.inferstructure.ICommandDispatcher;
import com.base.util.AnnotationUtils;
import com.base.command.BaseCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @Author: Z_Rashidi
 * @DATE : 8/16/2023
 */
@Configuration
public class CommandDispatcherProcess {
    private static final String BASE_PACKAGE = "com.base";

    @Autowired
    private ICommandDispatcher icommandDispatcher;

    @Bean
    void process() {
        Set<Class<?>> clazz = AnnotationUtils.findAllClasses(BASE_PACKAGE);
        Set<Class<?>> commandHandler = AnnotationUtils.findAnnotatedClasses(BASE_PACKAGE, InterfaceCommandHandler.class);
        for (Class<?> aClass : clazz) {
            if (BaseCommand.class.isAssignableFrom(aClass)) {

                List<Method[]> listMethods = commandHandler.stream().map(
                                command ->
                                        command.getDeclaredMethods()).
                        collect(Collectors.toList());

                commandHandler.stream().forEach(aClass1 -> {
                        System.out.println("");

                listMethods.stream()
                        .flatMap(Arrays::stream)
                        .filter(method -> aClass.getTypeName().equals(method.getParameterTypes()[0].getName()))
                         .map(method -> icommandDispatcher.registerHandler2(aClass,functionMethod(aClass1,method)))
                        .forEach(System.out::println);

                });
//                Stream<Method> methodStream = listMethods.stream()
//                        .flatMap(methodArray -> Stream.of(methodArray))
//
//                        ;
//
//                // .forEach(method -> System.out.println(method.getName()));
//
//                listMethods.stream()
//                        .flatMap(Stream::of)
//                        .map(CommandDispatcherProcess::printMethodInfo)
//                              ;

            }

        }

    }
    public static CommandHandlerMethod functionMethod(Class<?> aClass1, Method method) {

        try {
            Method declaredMethod = CommandHandlerMethod.class.getDeclaredMethod("handle", aClass1.getDeclaringClass());
            declaredMethod.invoke(method, method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Stream<?> printMethodInfo(Method method) {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();

        System.out.println("Method Name: " + methodName);
        System.out.println("Parameter Types: ");
        for (Class<?> paramType : parameterTypes) {
            System.out.println(paramType.getName());
        }
        System.out.println("------------------");
        return Arrays.stream(parameterTypes).toList().stream()
                .flatMap(Stream::of);
    }
}
