package com.example.tarantoolservice.controller;

import com.example.tarantoolservice.entity.Pokemon;
import com.example.tarantoolservice.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/pokemon/create")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.createPokemon(pokemon.getId(), pokemon.getName());
    }

    @PutMapping("/pokemon/update/{id}")
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon, @PathVariable int id) {
        return pokemonService.updatePokemon(pokemon.getId(), pokemon.getName());
    }

    @GetMapping("/pokemon/get/{id}")
    public Pokemon getPokemon(@PathVariable long id){
        return pokemonService.getPokemon(id);
    }

    @DeleteMapping("/pokemon/delete/{id}")
    public String deleteUser(@PathVariable int id){
        pokemonService.deletePokemon(id);
        return "You used Delete method";
    }
}
