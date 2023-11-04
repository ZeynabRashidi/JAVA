package com.base.annoatation.sample;

import com.base.annoatation.InterfaceCommandHandler;

/**
 * @Author: Z_Rashidi
 * @DATE : 8/16/2023
 */
@InterfaceCommandHandler
public interface SampleClassCommandHandler {

    void handler(SampleBaseCommand  command);

}
