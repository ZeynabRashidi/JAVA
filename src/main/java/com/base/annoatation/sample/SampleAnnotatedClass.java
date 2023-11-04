package com.base.annoatation.sample;



import com.base.annoatation.AggregateRoot;
import com.base.annoatation.CommandHandler;
import com.base.domain.BaseAggregateRoot;

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
