package com.se.generic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStudent {

    public static void main(String[] args) {

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        List<Student> students = new ArrayList<>();

        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        students.add(obj1);

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        students.add(obj2);

        Student obj3 = new Student();
        obj3.setName("zilap");
        obj3.addBook("Learning C++");
        obj3.addBook("Effective Java (3nd Edition)");

        students.add(obj3);



        Map<String, List<String>> maps = students.stream().collect(Collectors.toMap(Student::getName, Student::getBook, (existing, replacement) -> replacement));

        Map<String, Long> c = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(c);
        System.out.println(maps);


        List<Item> items2 = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<BigDecimal, List<Item>> bigDecimalListMap = items2.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(bigDecimalListMap);

        Map<BigDecimal, List<String>> bigDecimalListMap1 = items2.stream().collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toList())));

        System.out.println(bigDecimalListMap1);


    }
}
