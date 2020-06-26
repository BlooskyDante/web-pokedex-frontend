package com.pokedex.web.entity;

import java.util.List;

public class DetailedPokemonAbstraction extends SimplifiedPokemon {
    private List<String> moves;
    private EvolutionWrapper evolutionWrapper;

    public DetailedPokemonAbstraction() {
        super();
    }

    public DetailedPokemonAbstraction(SimplifiedPokemon simplifiedPokemon,
                                      List<String> moves,
                                      EvolutionWrapper wrapper) {
        super(simplifiedPokemon.getName(),
                simplifiedPokemon.getWeight(),
                simplifiedPokemon.getTypes(),
                simplifiedPokemon.getAbilities(),
                simplifiedPokemon.getSpriteUrl());

        this.moves = moves;
        this.evolutionWrapper = wrapper;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public EvolutionWrapper getEvolutionWrapper() {
        return evolutionWrapper;
    }

    public void setEvolutionWrapper(EvolutionWrapper evolutionWrapper) {
        this.evolutionWrapper = evolutionWrapper;
    }

    @Override
    public String toString() {
        return "DetailedPokemonAbstraction{" +
                "moves=" + moves +
                ", evolutionWrapper=" + evolutionWrapper +
                '}';
    }
}