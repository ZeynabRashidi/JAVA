package com.cbs.framework.inferstructure;

import com.cbs.framework.command.CommandHandlerMethod;
import com.cbs.framework.command.BaseCommand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CommandDispatcherImpl implements ICommandDispatcher { // Concrete Mediator

    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routs=  new HashMap<>();

    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handle) {
        var  handlers=routs.computeIfAbsent(type,c-> new LinkedList<>()); //computeIfAbsent(Key, Function)
        handlers.add(handle);

    }

    @Override
    public void send(BaseCommand command) {
        var  handlers=routs.get(command.getClass());

        if (handlers==null|| handlers.size()==0 ){
            throw new RuntimeException(" Cannot Command handler was register");
        }
        if (handlers.size()>1){
            throw new RuntimeException(" Cannot send to be more handler");
        }
        // Functional method
     handlers.get(0).handle(command);
    }

    @Override
    public <T extends BaseCommand> Object registerHandler2(Class<?> aClass, Object tCommandHandlerMethod) {

        return null;
    }
}
