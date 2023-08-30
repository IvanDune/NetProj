package com.example.servingwebcontent.dto.dnd.characters;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="race")
@Getter
@Setter
@NoArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="abilities")
    @OneToMany
    @CollectionTable(name = "race_abilities", joinColumns = @JoinColumn(name = "race_id"))
    private Set<RaceAbility> raceAbilitySet;

    @Column(name="varieties")
    @OneToMany
    @CollectionTable(name = "race_varieties", joinColumns = @JoinColumn(name = "race_id"))
    private Set<RaceVariety> raceVarietySet;

    @Column(name="buffs")
    @ManyToMany
    @CollectionTable(name = "race_buffs", joinColumns = @JoinColumn(name = "race_id"))
    @Enumerated(EnumType.STRING)
    private Set<CharacteristicBuff> buffs;

    @Column(name = "speed")
    private int speed;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    public Race(String name, Set<RaceAbility> raceAbilitySet, Set<CharacteristicBuff> buffs, int speed, int age, String description) {
        this.name = name;
        this.raceAbilitySet = raceAbilitySet;
        this.buffs = buffs;
        this.speed = speed;
        this.age = age;
        this.description = description;
    }
}
