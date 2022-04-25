package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);


    Optional<Book> save(BookDto bookDto);


    Optional<Book> update(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> rent(Long id);
}
