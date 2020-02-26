package com.se.generic;

import java.util.Comparator;

public class ComparatorTesting implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getHeight() - o2.getHeight();
    }

}
