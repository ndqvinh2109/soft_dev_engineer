package com.se.concurrency;

class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        final EBlockingQueue<Integer> q = new EBlockingQueue<>(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        q.enqueue(new Integer(i));
                        System.out.println("enqueued " + i);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    try {
                        System.out.println("Thread 2 dequeued: " + q.dequeue());
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    try {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        t1.start();
        Thread.sleep(4000);


        t2.start();

        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }
}

class EBlockingQueue<T> {

    T[] array;
    Object lock = new Object();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public EBlockingQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;
            lock.notify();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        synchronized (lock) {

            while (size == 0) {
                lock.wait();
            }

            if (head == capacity) {
                head = 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            lock.notify();
        }
        return item;
    }

}
