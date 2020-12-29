package com.example.tarantoolservice.service.impl;

import com.example.tarantoolservice.entity.Pokemon;
import com.example.tarantoolservice.service.PokemonService;
import org.springframework.stereotype.Service;
import org.tarantool.Iterator;
import org.tarantool.TarantoolClient;
import org.tarantool.TarantoolClientConfig;
import org.tarantool.TarantoolClientImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PokemonsServiceImpl implements PokemonService {
    private TarantoolClient tarantoolClient = null;

    private void config(){
        TarantoolClientConfig config = new TarantoolClientConfig();
        tarantoolClient = new TarantoolClientImpl("localhost:3301", config);
    }

    @Override
    public Pokemon getPokemon(long id) {
        if (tarantoolClient == null){
            config();
        }
        List<?> result = tarantoolClient.syncOps().select(512, 0, Collections.singletonList(id), 0, 1, Iterator.ALL);
        List<Object> fields = (ArrayList<Object>)result.get(0);
        return new Pokemon((Integer)fields.get(0), (String)fields.get(1));
    }

    @Override
    public Pokemon createPokemon(long id, String name) {
        if (tarantoolClient == null){
            config();
        }
        List<?> result = tarantoolClient.syncOps().insert(512, List.of(id, name));
        List<Object> fields = (ArrayList<Object>)result.get(0);
        return new Pokemon((Integer)fields.get(0), (String)fields.get(1));
    }

    @Override
    public Pokemon updatePokemon(long id, String name) {
        if (tarantoolClient == null){
            config();
        }
        List<?> result = tarantoolClient.syncOps().update(512, Collections.singletonList(id), List.of("=", "name", name));
        List<Object> fields = (ArrayList<Object>)result.get(0);
        return new Pokemon((Integer)fields.get(0), (String)fields.get(1));
    }

    @Override
    public void deletePokemon(long id) {
        if (tarantoolClient == null){
            config();
        }
        tarantoolClient.syncOps().delete(512, Collections.singletonList(id));
    }
}
