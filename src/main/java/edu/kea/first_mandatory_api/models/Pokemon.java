package edu.kea.first_mandatory_api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="pokemons")
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokemon_id;

    @Column
    private int generation_id;

    @Column
    private String name;

    @Column
    private String primary_type;

    @Column
    private String secondary_type;

    @Column
    private int generation;
}
