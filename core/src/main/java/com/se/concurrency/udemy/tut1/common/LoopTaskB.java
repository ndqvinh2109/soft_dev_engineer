package com.se.concurrency.udemy.tut1.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {

    private static int count = 0;
    private int id;

    @Override
    public void run() {

        System.out.println("##### <TASK-" + id + "> STARTING #####");

        for (int i = 0; i <= 10; i++) {
            System.out.println("<TASK- " + id +"> ==> "+ i);

            try {
                TimeUnit.MILLISECONDS.sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("##### <TASK-" + id + ">  DONE #####");
    }

    public LoopTaskB(){
        this.id = ++count;
    }

}
