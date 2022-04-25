package com.example.demo.web.rest;

import com.example.demo.models.Author;
import com.example.demo.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAuthors(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
            return this.authorService.findById(id).map(author -> ResponseEntity.ok().body(author)).orElseGet(()->ResponseEntity.badRequest().build());
    }
}
