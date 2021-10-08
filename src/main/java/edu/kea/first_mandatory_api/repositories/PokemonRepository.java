package edu.kea.first_mandatory_api.repositories;

import edu.kea.first_mandatory_api.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
