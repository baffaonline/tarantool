package com.example.tarantoolservice.controller;

import com.example.tarantoolservice.entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonController {

    @PostMapping("/pokemon/create")
    public String addPokemon(@RequestBody Pokemon pokemon){
        return "You used Create method";
    }

    @PutMapping("/pokemon/update/{id}")
    public String updatePokemon(@RequestBody Pokemon pokemon, @PathVariable int id) {
        return "You used Update method";
    }

    @GetMapping("/pokemon/get/all")
    public String getPokemons(){
        return "You used Get method";
    }

    @DeleteMapping("/pokemon/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return "You used Delete method";
    }
}
