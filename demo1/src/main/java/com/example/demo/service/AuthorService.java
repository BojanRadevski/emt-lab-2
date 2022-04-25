package com.example.demo.service;

import com.example.demo.models.Author;
import com.example.demo.models.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();

    public Optional<Author> findById(Long id);

    public Optional<Author> save(String name, String surname, Country country);

    public Optional<Author> edit(Long id,String name,String surname,Country country);

    public void delete(Long id);

}
