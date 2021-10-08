package edu.kea.first_mandatory_api.controllers;

import edu.kea.first_mandatory_api.models.Pokemon;
import edu.kea.first_mandatory_api.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Pokemons {

    @Autowired
    PokemonRepository pokemons;

    @GetMapping("/pokemon")
    public Iterable<Pokemon> getPokemons(){
        return pokemons.findAll();
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable Long id){
        return pokemons.findById(id).get();
    }

    @PostMapping("/pokemon")
    public Pokemon addPokemon(@RequestBody Pokemon newPokemon){
        return pokemons.save(newPokemon);
    }

    @PutMapping("/pokemon/{id}")
    public String replacePokemon(@PathVariable Long id,@RequestBody Pokemon newPokemon){
        if (pokemons.existsById(id)) {
            newPokemon.setPokemon_id(id);
            pokemons.save(newPokemon);
            return "Pokemon was created";
        } else {
            return "Pokemon not found";
        }
    }

    @PatchMapping("/pokemon/{id}")
    public String updatePokemon(@PathVariable Long id, @RequestBody Pokemon newPokemon){
        return pokemons.findById(id).map(foundPokemon -> {
            if (newPokemon.getGeneration_id() != 0) {
                foundPokemon.setGeneration_id(newPokemon.getGeneration_id());
            }
            if (newPokemon.getName() != null) {
                foundPokemon.setName(newPokemon.getName());
            }
            if (newPokemon.getPrimary_type() != null) {
                foundPokemon.setPrimary_type(newPokemon.getPrimary_type());
            }
            if (newPokemon.getSecondary_type() != null) {
                foundPokemon.setSecondary_type(newPokemon.getSecondary_type());
            }
            if (newPokemon.getGeneration() != 0) {
                foundPokemon.setGeneration(newPokemon.getGeneration());
            }
            pokemons.save(foundPokemon);
            return "Pokemon updated";
        }).orElse("Pokemon not found");
    }

    @DeleteMapping("/pokemon/{id}")
    public String deletePokemon(@PathVariable Long id){
        String name = pokemons.findById(id).get().getName();
        pokemons.deleteById(id);
        return name;
    }
}
