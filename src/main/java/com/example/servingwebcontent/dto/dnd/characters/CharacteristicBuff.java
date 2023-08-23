package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="characteristic_buff")
@Getter
@Setter
@NoArgsConstructor
public class CharacteristicBuff  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mod")
    private int mod;

    public CharacteristicBuff(String name, int mod) {
        this.name = name;
        this.mod = mod;
    }
}
