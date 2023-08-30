package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="race_ability")
@Getter
@Setter
@NoArgsConstructor
public class RaceAbility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "raceInd")
    private Long raceInd;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public RaceAbility(Long raceInd, String name, String description) {
        this.raceInd = raceInd;
        this.name = name;
        this.description = description;
    }
}
