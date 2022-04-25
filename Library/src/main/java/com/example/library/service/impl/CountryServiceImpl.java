package com.example.library.service.impl;

import com.example.library.model.Country;
import com.example.library.model.dto.CountryDto;
import com.example.library.model.exceptions.CountryNotFoundException;
import com.example.library.repository.CountryRepository;
import com.example.library.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {

        Country country = this.countryRepository.save(Country.builder()
                .name(countryDto.getName())
                .continent(countryDto.getContinent())
                .build());

        return Optional.of(country);
    }

    @Override
    public Optional<Country> update(Long id, CountryDto countryDto){
        Country country = this.countryRepository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));

        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());

        this.countryRepository.save(country);
        return Optional.of(country);
    }
    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

}
