package com.se.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Dog[] dogs2 = {new Dog(), new Dog()};
        Cat[] cats2 = {new Cat(), new Cat(), new Cat()};

        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat());
        cats.add(new Cat());

        List<Animal> animals = new ArrayList<Animal>();

        Test test = new Test();
        //test.printAnimals2(dogs2);

        //test.printAnimals(dogs);

        //List<Animal> animals = new ArrayList<>();
        //animals.add(new Dog());
        //animals.add(new Cat());

        //test.printAnimals(animals);

        //test.addAnimal(cats2);

        test.addAnimal(dogs);
        test.addAnimal(animals);

        test.addAnimal3(cats);

        test.addAnimal4(dogs);

        ComparatorTesting comparator = new ComparatorTesting();

        Comparator<Animal> comparatorTesting = (Animal a, Animal b) -> a.getHeight() - b.getHeight();

        Comparator<Animal> comparator1 = Comparator.comparing(Animal::getHeight);

        Collections.sort(animals, comparatorTesting);



    }

    public void addAnimal4(List<?> animals) {
        //animals.add(new Dog());
    }

    public void addAnimal5(List<Object> animals) {
        //animals.add(new Dog());
    }

    public void addAnimal3(List<? extends Animal> animals) {

    }

    public void addAnimal(List<? super Dog> animals) {
        animals.add(new Dog());
    }

    public void addAnimal2(Animal[] animals) {
        animals[0] = new Dog();
    }

    public void printAnimals2(Animal[] animals) {
        for (Animal animal : animals) {
            animal.print();
        }
    }

    public void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.print();
        }
    }
}
