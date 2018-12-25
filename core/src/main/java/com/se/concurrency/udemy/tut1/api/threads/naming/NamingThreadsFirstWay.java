package com.se.concurrency.udemy.tut1.api.threads.naming;

import com.se.concurrency.udemy.tut1.common.LoopTaskB;

public class NamingThreadsFirstWay {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("["+currentThreadName+"] Main thread starts here...");

        new Thread(new LoopTaskB()).start();

        Thread t2 = new Thread(new LoopTaskB());
        t2.start();

        System.out.println("["+currentThreadName+"] Main thread ends here...");

    }

}
