package com.pokedex.web.entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PokemonPaginatedListResponse {
    private Integer count;
    private List<SimplifiedPokemon> pokemonList;

    public PokemonPaginatedListResponse() {
        this.count = 0;
        this.pokemonList = Collections.emptyList();
    }
}