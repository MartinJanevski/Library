package com.example.library.controller;

import com.example.library.model.Country;
import com.example.library.model.dto.CountryDto;
import com.example.library.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;


    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return  ResponseEntity.ok().body(this.countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return this.countryService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
        return this.countryService.save(countryDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return this.countryService.update(id, countryDto)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.countryService.deleteById(id);
        if(this.countryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
