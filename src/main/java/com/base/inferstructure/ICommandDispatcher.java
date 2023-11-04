package com.base.inferstructure;

import com.base.command.BaseCommand;
import com.base.command.CommandHandlerMethod;

public interface ICommandDispatcher { //Mediator

  <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handle);

   void send(BaseCommand command);


    <T extends BaseCommand> Object registerHandler2(Class<?> aClass, CommandHandlerMethod<T> tCommandHandlerMethod);
}
