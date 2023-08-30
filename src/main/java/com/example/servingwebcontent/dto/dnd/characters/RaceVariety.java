package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="race_variety")
@Getter
@Setter
@NoArgsConstructor
public class RaceVariety {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name= "description")
    private String description;

    @Column(name="buffs")
    @ManyToMany
    @CollectionTable(name = "raceVariety_buff", joinColumns = @JoinColumn(name = "raceVariety_id"))
    @Enumerated(EnumType.STRING)
    private Set<CharacteristicBuff> buffs;

    @Column(name="abilities")
    @OneToMany
    @CollectionTable(name = "raceVariety_abilities", joinColumns = @JoinColumn(name = "raceVariety_id"))
    private Set<RaceAbility> raceAbilitySet;

    public RaceVariety(String name) {
        this.name = name;
    }

    public RaceVariety(String name, Set<CharacteristicBuff> buffs, Set<RaceAbility> raceAbilitySet, String description) {
        this.name = name;
        this.buffs = buffs;
        this.raceAbilitySet = raceAbilitySet;
        this.description=description;
    }
}
