package com.example.demo.data;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.models.Country;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.CountryRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    private final AuthorRepo authorRepository;
    private final BookRepo bookRepository;
    private final CountryRepo countryRepository;

    public DataHolder(AuthorRepo authorRepository, BookRepo bookRepository, CountryRepo countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Serbia", "Europe");
        Country country2 = new Country("Macedonia", "Europe");
        Country country3 = new Country("Russia", "Europe");
        Country country4 = new Country("France", "Europe");
        Country country5 = new Country("China","Asia");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);
        this.countryRepository.save(country5);

        Author author1 = new Author("Nikola", "Nikolovic", country1);
        Author author2 = new Author("Bojan", "Radevski", country3);
        Author author3 = new Author("Vladimir", "Putin", country2);
        Author author4 = new Author("Kylian", "Mpabbe", country4);
        Author author5 = new Author("Chin","Chong",country5);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);
        this.authorRepository.save(author5);

        Book book1 = new Book("Zoki Poki", author2, 54, Category.THRILER);
        Book book2 = new Book("Shagrinska Kozha",author1, 12 ,Category.CLASSICS);
        Book book3 = new Book("The amazon way", author5, 123, Category.NOVEL);
        Book book5 = new Book("Crvenkapa", author4, 420, Category.BIOGRAPHY);
        Book book6 = new Book("Gilgamesh", author5, 312, Category.CLASSICS);
        Book book7 = new Book("Kasni Porasni", author3, 0, Category.CLASSICS);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
        this.bookRepository.save(book7);
    }

}
