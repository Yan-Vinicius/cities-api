package com.yan.citiesapi.controller;

import com.yan.citiesapi.model.Country;
import com.yan.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> countries(Pageable page){

        return countryRepository.findAll(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id){

        Optional<Country> country = countryRepository.findById(id);

        if (country.isPresent()) {
            return ResponseEntity.ok().body(country.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
