package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);


    Optional<Author> save(AuthorDto authorDto);


    Optional<Author> update(Long id, AuthorDto authorDto);

    void deleteById(Long id);

}
