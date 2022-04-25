package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return  ResponseEntity.ok().body(this.authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto) {
        return this.authorService.save(authorDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        return this.authorService.update(id, authorDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.authorService.deleteById(id);
        if(this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
