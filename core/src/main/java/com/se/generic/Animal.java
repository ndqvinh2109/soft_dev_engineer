package com.se.generic;

public abstract class Animal {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void print();

}
