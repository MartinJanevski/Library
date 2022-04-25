package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return  ResponseEntity.ok().body(this.bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.update(id, bookDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<Book> rent(@PathVariable Long id) {
        return this.bookService.rent(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
