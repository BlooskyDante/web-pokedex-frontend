package com.pokedex.web.service;

import com.pokedex.web.entity.DetailedPokemonAbstraction;
import com.pokedex.web.entity.PokemonPaginatedListResponse;
import com.pokedex.web.util.InvokeRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static com.pokedex.web.constant.Endpoint.POKEMON_DETAILS;
import static com.pokedex.web.constant.Endpoint.POKEMON_LIST_PAGINATED;

@Slf4j
@Service
public class PokedexServiceImpl implements PokedexService {
    private static final String ERROR = "Error: ";

    @Value("${pokedex.rest.url}")
    private String baseURL;

    @Autowired
    private InvokeRestService invoke;

    @Override
    @Cacheable("pokemonListPaginated")
    public PokemonPaginatedListResponse getPokemonListPaginated(Integer page) {
        PokemonPaginatedListResponse response;
        try{
            if (page !=  null && page >  0) {
                response = invoke.invokeRestService(baseURL + POKEMON_LIST_PAGINATED + page,
                        HttpMethod.GET, null,
                        PokemonPaginatedListResponse.class);
            } else {
                throw new IllegalArgumentException("La pagina no puede ser null ni menor que cero");
            }
        } catch (Exception e) {
            log.error(ERROR, e);
            response = null;
        }
        return response;
    }

    @Override
    @Cacheable("detailedPokemonByName")
    public DetailedPokemonAbstraction getDetailedPokemonByName(String name) {
        DetailedPokemonAbstraction response;
        try {
            if (name != null) {
                response = invoke.invokeRestService(baseURL + POKEMON_DETAILS + name,
                        HttpMethod.GET, null,
                        DetailedPokemonAbstraction.class);
            } else {
                throw new IllegalArgumentException("El nombre del pokemon no puede ser null");
            }
        } catch (Exception e) {
            log.error(ERROR, e);
            response = null;
        }
        return response;
    }
}
