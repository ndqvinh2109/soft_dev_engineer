package com.dt.arrays;

/**
 * Created by fpt-vnguyend on 28/08/2018.
 */
public class ResizableArray<E> {

    final private int initialCapacity = 10;
    private Object[] items;
    private int size;

    public ResizableArray() {
        this.items = new Object[initialCapacity];
        this.size = 0;
    }

    public ResizableArray(int capacity) {
        this.items = new Object[capacity];
        this.size = 0;
    }

    public void add(E element) {
        ensureExtraCapacity();
        items[size] = element;
        size ++;
    }

    public Object get(int index) {
        checkBounds(index);
        return items[index];
    }

    public void set(int index, E value) {
        checkBounds(index);
        items[index] = value;
    }

    public void checkBounds(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void ensureExtraCapacity() {
        if(size == items.length) {
            Object[] copy = new Object[size << 1];
            System.arraycopy(items, 0, copy, 0, size);
            items = copy;
        }
    }

    public void print() {
        System.out.print("[");
        if(size > 0) {
            for(int i = 0; i < size; i++) {
                if(i == size - 1) {
                    System.out.print(items[i]);
                    break;
                }
                System.out.print(items[i] + ", ");
            }
        }

        System.out.print("]\n");
    }

    public static void main(String[] args) {
        ResizableArray<Integer> arrInt = new ResizableArray<Integer>();

        System.out.println("arrInt current size: " + arrInt.size);
        System.out.println("arrInt current capacity: " + arrInt.items.length);
        for(int i = 0; i < 12; i++) {
            arrInt.add(i);
        }

        arrInt.print();

        System.out.println("arrInt current new size: " + arrInt.size);
        System.out.println("arrInt current new capacity: " + arrInt.items.length);

    }

}
