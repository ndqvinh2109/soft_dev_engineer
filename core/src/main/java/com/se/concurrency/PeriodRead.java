package com.se.concurrency;

import java.util.concurrent.*;

public class PeriodRead {
    private ScheduledExecutorService stpe;
    private ScheduledFuture<?> hndl;

    private static BlockingQueue<WorkUnit<String>> lbq = new LinkedBlockingQueue<>();


    private void run() {
        stpe = Executors.newScheduledThreadPool(2);
        final Runnable msgReader = new Runnable() {
            @Override
            public void run() {
                String nextMsg = lbq.poll().getWork();
                if (nextMsg != null) System.out.println("Msg received: "+ nextMsg);
            }
        };
        hndl = stpe.scheduleAtFixedRate(msgReader, 10, 10, TimeUnit.MILLISECONDS);
    }

    public void cancel() {
        final ScheduledFuture<?> myHndl = hndl;
        stpe.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Cancelled");
                myHndl.cancel(true);
            }
        }, 10, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        WorkUnit<String> msg1 = new WorkUnit<>("Vinh");
        lbq.put(msg1);

        PeriodRead periodRead = new PeriodRead();
        periodRead.run();
        periodRead.cancel();
    }
}
