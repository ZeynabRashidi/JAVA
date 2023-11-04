package com.cbs.framework.command;

import com.cbs.framework.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseCommand  extends Message {

    public BaseCommand(String id) {
        super(id);
        System.out.println("test git");

    }
}
