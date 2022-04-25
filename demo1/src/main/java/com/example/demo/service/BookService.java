package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.dto.BookDto;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> findAll();

    public Optional<Book> findById(Long id);

    public Optional<Book> save(BookDto bookDto);

    public Optional<Book> edit(Long id,BookDto bookDto);

    public void deleteById(Long id);

    public Optional<Book> markAsTaken(Long id);

}
