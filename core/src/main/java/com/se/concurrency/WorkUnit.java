package com.se.concurrency;

public class WorkUnit<T> {

    private final T work;

    public T getWork() {
        return work;
    }

    public WorkUnit(T work) {
        this.work = work;
    }
}
