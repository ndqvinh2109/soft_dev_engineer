package com.se.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());

    }

    public void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.print();
        }
    }
}
