package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.model.exceptions.CountryNotFoundException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.CountryRepository;
import com.example.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {

        Author author = this.authorRepository.save(Author.builder()
                .name(authorDto.getName())
                .surname(authorDto.getSurname())
                .country(this.countryRepository.findById(authorDto.getCountryId())
                        .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId())))
                .build());

        return Optional.of(author);
    }

    @Override
    public Optional<Author> update(Long id, AuthorDto authorDto){
        Author author = this.authorRepository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId())));

        this.authorRepository.save(author);
        return Optional.of(author);
    }


    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

}
