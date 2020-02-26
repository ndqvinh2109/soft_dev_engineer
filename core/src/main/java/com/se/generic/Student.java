package com.se.generic;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new ArrayList<>();
        }
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBook() {
        return book;
    }

    public void setBook(List<String> book) {
        this.book = book;
    }
}
