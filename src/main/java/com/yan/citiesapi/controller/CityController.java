package com.yan.citiesapi.controller;

import com.yan.citiesapi.model.City;
import com.yan.citiesapi.model.Country;
import com.yan.citiesapi.repository.CityRepository;
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
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Page<City> city (Pageable page){

        return cityRepository.findAll(page);

    }

    @GetMapping("{id}")
    public ResponseEntity<City> getById(@PathVariable Long id){

        Optional<City> city = cityRepository.findById(id);

        if (city.isPresent()) {
            return ResponseEntity.ok().body(city.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }


}
