package com.se.concurrency.udemy.tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FourthWay {
    public static void main(String[] args) {
        System.out.println("Main thread start here ");

        new Thread(new FourthTask()).start();

        Thread t = new Thread(new FourthTask());
        t.start();

        System.out.println("Main thread e here ");
    }

}


class FourthTask extends Thread {
    private static int count = 0;
    private int id;

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("FirstTask.run id = " + id +" >> "+ i);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public FourthTask(){
        this.id = ++count;
    }

}