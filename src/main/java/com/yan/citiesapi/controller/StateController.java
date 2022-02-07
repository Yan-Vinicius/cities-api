package com.yan.citiesapi.controller;

import com.yan.citiesapi.model.Country;
import com.yan.citiesapi.model.State;
import com.yan.citiesapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @GetMapping
    public List<State> states(){

        return stateRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getById(@PathVariable Long id){

        Optional<State> state = stateRepository.findById(id);

        if (state.isPresent()) {
            return ResponseEntity.ok().body(state.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}
