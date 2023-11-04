package com.cbs.framework.command;



@FunctionalInterface
public interface CommandHandlerMethod<T extends  BaseCommand> {

    void handle(T command);
}
