package com.cbs.framework.inferstructure;

import com.cbs.framework.command.BaseCommand;
import com.cbs.framework.command.CommandHandlerMethod;

public interface ICommandDispatcher { //Mediator

  <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handle);

   void send(BaseCommand command);


    <T extends BaseCommand> Object registerHandler2(Class<?> aClass, CommandHandlerMethod<T> tCommandHandlerMethod);
}
