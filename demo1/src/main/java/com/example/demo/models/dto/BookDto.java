package com.example.demo.models.dto;

import com.example.demo.models.Category;
import lombok.Data;

@Data
public class BookDto {

    public String name;

    public Category category;

    public Long author;

    public Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
