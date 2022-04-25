package com.example.demo.service.impl;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.models.Country;
import com.example.demo.models.dto.BookDto;
import com.example.demo.models.exceptions.AuthorNotFoundException;
import com.example.demo.models.exceptions.BookNotFoundException;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.CountryRepo;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private CountryRepo countryRepo;

    public BookServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, CountryRepo countryRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepo.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepo.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.author));
        return Optional.of(this.bookRepo.save(new Book(bookDto.getName(), author, bookDto.getAvailableCopies(),bookDto.getCategory())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Author author = this.authorRepo.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.author));
        book.setAuthor(author);
        Category category = Category.valueOf(bookDto.getCategory().toString());
        book.setCategory(category);
        book.setName(bookDto.getName());
        return Optional.of(this.bookRepo.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepo.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        return Optional.empty();
    }
}
