package com.example.demo.web.rest;

import com.example.demo.models.Book;
import com.example.demo.models.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id).map(book->ResponseEntity.ok().body(book)).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@RequestBody BookDto bookDto,@PathVariable Long id ){
        return bookService.edit(id, bookDto).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
        return bookService.markAsTaken(id).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
