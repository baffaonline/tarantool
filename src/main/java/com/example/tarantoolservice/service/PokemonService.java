package com.example.tarantoolservice.service;

import com.example.tarantoolservice.entity.Pokemon;

import java.util.List;

public interface PokemonService {
    Pokemon getPokemon(long id);

    Pokemon createPokemon(long id, String name);

    Pokemon updatePokemon(long id, String name);

    void deletePokemon(long id);
}
