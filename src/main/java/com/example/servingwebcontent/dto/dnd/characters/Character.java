package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="characters")
@Getter
@Setter
@NoArgsConstructor
public class Character extends Essence{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="race")
    private Long raceId;

    @Column(name="raceVariety")
    private Long raceVariety;

    @Column(name="class")
    private Long classId;

    @Column(name="characteristics")
    private Long characteristicsId;

    @Column(name="userId")
    private Long userId;

    @Column(name="level")
    private int level;

    @Column(name="className")
    private String className;

    @Column(name="raceName")
    private String raceName;


    public Character(String name, Long raceId, Long classId, Long characteristicsId, Long userId) {
        this.name = name;
        this.raceId = raceId;
        this.classId = classId;
        this.characteristicsId = characteristicsId;
        this.userId = userId;
    }

}
