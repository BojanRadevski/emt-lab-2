package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    private Category category;

    public Book() {}

    public Book(String name,Author author,Integer availableCopies,Category category){
        this.name=name;
        this.author=author;
        this.availableCopies=availableCopies;
        this.category=category;
    }
}
