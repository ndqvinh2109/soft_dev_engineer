package com.se.concurrency.udemy.tut1.api.executors.running;

import com.se.concurrency.udemy.tut1.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ...");

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());

        executorService.shutdown();

        executorService.execute(new LoopTaskA());

     System.out.println("Main thread ends here ...");
    }

}
