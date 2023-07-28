package com.example.servingwebcontent.dto.dnd.characters;

import javax.persistence.*;

@Entity
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

    public Armor(){

    }

    public Armor(String name, String type, int baseAC, int price, int strength, boolean disadvantage, int weight) {
        this.name = name;
        this.type = type;
        this.baseAC = baseAC;
        this.price = price;
        this.strength = strength;
        this.disadvantage = disadvantage;
        this.weight=weight;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBaseAC() {
        return baseAC;
    }

    public void setBaseAC(int baseAC) {
        this.baseAC = baseAC;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(boolean disadvantage) {
        this.disadvantage = disadvantage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
