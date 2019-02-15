package com.se.concurrency.udemy.tut1.api.executors.naming;

import com.se.concurrency.udemy.tut1.common.LoopTaskC;
import com.se.concurrency.udemy.tut1.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThreads {

    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();

        System.out.println("["+currentThreadName+"] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());

        System.out.println("["+currentThreadName+"] Main thread ends here...");

    }
}
