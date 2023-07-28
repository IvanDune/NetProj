package com.example.servingwebcontent.dto.dnd.characters;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RaceVarieties {
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
    private Set<RaceAbilities> raceAbilitiesSet;

    public RaceVarieties(){

    }

    public RaceVarieties(String name) {
        this.name = name;
    }

    public RaceVarieties(String name, Set<CharacteristicBuff> buffs, Set<RaceAbilities> raceAbilitiesSet, String description) {
        this.name = name;
        this.buffs = buffs;
        this.raceAbilitiesSet = raceAbilitiesSet;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CharacteristicBuff> getBuffs() {
        return buffs;
    }

    public void setBuffs(Set<CharacteristicBuff> buffs) {
        this.buffs = buffs;
    }

    public Set<RaceAbilities> getRaceAbilitiesSet() {
        return raceAbilitiesSet;
    }

    public void setRaceAbilitiesSet(Set<RaceAbilities> raceAbilitiesSet) {
        this.raceAbilitiesSet = raceAbilitiesSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
