package com.pokedex.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class EvolutionChain {
    private List<EvolutionChain> evolvesTo;
    private Result species;
}
