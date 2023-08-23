package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="race_ability")
@Getter
@Setter
@NoArgsConstructor
public class RaceAbilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "raceId")
    private Long raceId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public RaceAbilities(Long raceId, String name, String description) {
        this.raceId = raceId;
        this.name = name;
        this.description = description;
    }
}
