package com.example.demo.service.impl;

import com.example.demo.models.Country;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.CountryRepo;
import com.example.demo.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private CountryRepo countryRepo;

    public CountryServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, CountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepo.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.empty();
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
