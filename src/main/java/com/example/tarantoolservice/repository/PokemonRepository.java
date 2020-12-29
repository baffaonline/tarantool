package com.example.tarantoolservice.repository;

import com.example.tarantoolservice.entity.Pokemon;
import org.springframework.data.tarantool.repository.TarantoolRepository;

public interface PokemonRepository extends TarantoolRepository<Pokemon, Long> {
}
