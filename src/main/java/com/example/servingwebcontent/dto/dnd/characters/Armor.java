package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="armor")
@Getter
@Setter
@NoArgsConstructor
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long Id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="baseAC")
    private int baseAC;

    @Column(name="price")
    private int price;

    @Column(name="strength")
    private int strength;

    @Column(name="disadvantage")
    private boolean disadvantage;

    @Column(name="weight")
    private int weight;

    public Armor(String name, String type, int baseAC, int price, int strength, boolean disadvantage, int weight) {
        this.name = name;
        this.type = type;
        this.baseAC = baseAC;
        this.price = price;
        this.strength = strength;
        this.disadvantage = disadvantage;
        this.weight=weight;
    }


}
