package com.pokedex.web.constant;

public abstract class Endpoint {
    private Endpoint () {
        // Class not meant to be instantiated
    }

    public static final String POKEMON_LIST_PAGINATED = "/page/";
    public static final String POKEMON_DETAILS = "/name/";
}
