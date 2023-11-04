package com.cbs.framework.annoatation.sample;



import com.cbs.framework.annoatation.AggregateRoot;
import com.cbs.framework.annoatation.CommandHandler;
import com.cbs.framework.domain.BaseAggregateRoot;

/**
 * @author B_Aliaskari
 */
@AggregateRoot
public class SampleAnnotatedClass extends BaseAggregateRoot {


    @CommandHandler
    public void handler(){
        System.out.println("handler");
    }

    @CommandHandler
    public void handler2(){
        System.out.println("handler2");
    }

    public void handler3(){
        System.out.println("handler3");
    }
}
