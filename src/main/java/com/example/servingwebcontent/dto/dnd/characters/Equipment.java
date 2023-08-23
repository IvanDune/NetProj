package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="equipment")
@Getter
@Setter
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "weight")
    private int weight;

    @Column(name = "description")
    private String description;

    public Equipment(String name, int price, int weight, String description) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }
}
