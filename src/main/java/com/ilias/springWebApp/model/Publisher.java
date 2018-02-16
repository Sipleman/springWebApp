package com.ilias.springWebApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    private Book book;

    public Book getBook() {
        return book;
    }

    public Publisher() {
    }

    public Publisher(String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher(Long id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Book getBooks() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
