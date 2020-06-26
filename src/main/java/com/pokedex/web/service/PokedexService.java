package com.pokedex.web.service;

import com.pokedex.web.entity.DetailedPokemonAbstraction;
import com.pokedex.web.entity.PokemonPaginatedListResponse;

public interface PokedexService {
    PokemonPaginatedListResponse getPokemonListPaginated(Integer page);

    DetailedPokemonAbstraction getDetailedPokemonByName(String name);
}
