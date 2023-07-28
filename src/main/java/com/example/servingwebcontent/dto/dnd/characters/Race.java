package com.example.servingwebcontent.dto.dnd.characters;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="abilities")
    @OneToMany
    @CollectionTable(name = "race_ability", joinColumns = @JoinColumn(name = "race_id"))
    private Set<RaceAbilities> raceAbilitiesSet;

    @Column(name="varieties")
    @OneToMany
    @CollectionTable(name = "race_variety", joinColumns = @JoinColumn(name = "race_id"))
    private Set<RaceVarieties> raceVarietiesSet;

    @Column(name="buffs")
    @ManyToMany
    @CollectionTable(name = "race_buff", joinColumns = @JoinColumn(name = "race_id"))
    @Enumerated(EnumType.STRING)
    private Set<CharacteristicBuff> buffs;

    @Column(name = "speed")
    private int speed;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    public Race(){

    }

    public Race(String name, Set<RaceAbilities> raceAbilitiesSet, Set<CharacteristicBuff> buffs, int speed, int age, String description) {
        this.name = name;
        this.raceAbilitiesSet = raceAbilitiesSet;
        this.buffs = buffs;
        this.speed = speed;
        this.age = age;
        this.description = description;
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

    public Set<RaceAbilities> getRaceAbilitiesSet() {
        return raceAbilitiesSet;
    }

    public void setRaceAbilitiesSet(Set<RaceAbilities> raceAbilitiesSet) {
        this.raceAbilitiesSet = raceAbilitiesSet;
    }

    public Set<RaceVarieties> getRaceVarietiesSet() {
        return raceVarietiesSet;
    }

    public void setRaceVarietiesSet(Set<RaceVarieties> raceVarietiesSet) {
        this.raceVarietiesSet = raceVarietiesSet;
    }

    public Set<CharacteristicBuff> getBuffs() {
        return buffs;
    }

    public void setBuffs(Set<CharacteristicBuff> buffs) {
        this.buffs = buffs;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
