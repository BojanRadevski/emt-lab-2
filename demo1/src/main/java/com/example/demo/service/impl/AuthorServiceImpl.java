package com.example.demo.service.impl;

import com.example.demo.models.Author;
import com.example.demo.models.Country;
import com.example.demo.models.exceptions.AuthorNotFoundException;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.CountryRepo;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private CountryRepo countryRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, CountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepo.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepo.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        return Optional.of(this.authorRepo.save(new Author(name,surname,country)));
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Country country) {
        Author author1 = this.authorRepo.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
        author1.setName(name);
        author1.setSurname(surname);
        author1.setCountry(country);
        authorRepo.save(author1);
        return authorRepo.findById(id);

    }

    @Override
    public void delete(Long id) {
        authorRepo.deleteById(id);
    }
}
