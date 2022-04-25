package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.model.exceptions.AuthorNotFoundException;
import com.example.library.model.exceptions.BookNotFoundException;
import com.example.library.model.exceptions.CountryNotFoundException;
import com.example.library.model.exceptions.NoCopiesLeftException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        Book book = this.bookRepository.save(Book.builder()
                .name(bookDto.getName())
                .category(bookDto.getCategory())
                        .author((this.authorRepository.findById(bookDto.getAuthorId())
                                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()))))
                .availableCopies(bookDto.getAvailableCopies())
                .build());

        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto){
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setAuthor((this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()))));
        this.bookRepository.save(book);
        return Optional.of(book);
    }
    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rent(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));

        if(book.getAvailableCopies() < 1){
            throw new NoCopiesLeftException(id);
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
