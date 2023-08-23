package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="class_ability")
@Getter
@Setter
@NoArgsConstructor
public class ClassAbilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="level")
    private int level;

    public ClassAbilities(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }
}
