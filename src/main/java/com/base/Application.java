package com.base;

import com.base.annoatation.config.CommandHandlerProcess;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

/**
 * @author B_Aliaskari
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @PostConstruct
    public void init(){
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");

        CommandHandlerProcess process= new CommandHandlerProcess();
        try {
            process.doSomethingAfterStartup();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
