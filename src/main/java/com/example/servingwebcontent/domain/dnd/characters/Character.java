package com.example.servingwebcontent.domain.dnd.characters;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Character extends Essence{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="race")
    private Long raceId;

    @Column(name="class")
    private Long classId;

    @Column(name="characteristics")
    private Long characteristicsId;


    public Character(){

    }

    public Character(String name, Long raceId, Long classId, Long characteristicsId) {
        this.name = name;
        this.raceId = raceId;
        this.classId = classId;
        this.characteristicsId = characteristicsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getCharacteristicsId() {
        return characteristicsId;
    }

    public void setCharacteristicsId(Long characteristicsId) {
        this.characteristicsId = characteristicsId;
    }
}
