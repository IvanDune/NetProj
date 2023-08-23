package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="weapon_property")
@Getter
@Setter
@NoArgsConstructor
public class WeaponProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public WeaponProperties(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
