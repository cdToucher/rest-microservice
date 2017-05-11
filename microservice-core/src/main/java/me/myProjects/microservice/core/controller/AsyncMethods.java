package me.myProjects.microservice.core.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by chendong on 2017/5/11.
 */
@Component
public class AsyncMethods {

    @Async
    public void doLater() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("do work.............................................");
    }

}
