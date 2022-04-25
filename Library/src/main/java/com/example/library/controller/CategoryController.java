package com.example.library.controller;


import com.example.library.model.enums.Category;
import com.example.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return  ResponseEntity.ok().body(categoryService.findAll());
    }


}
