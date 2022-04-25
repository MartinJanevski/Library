package com.example.library.service.impl;

import com.example.library.model.enums.Category;
import com.example.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    @Override
    public List<Category> findAll() {
        return Arrays.asList(Category.values());
    }

}
