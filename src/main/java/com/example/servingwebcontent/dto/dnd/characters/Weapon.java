package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="weapon")
@Getter
@Setter
@NoArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "valueDamage")
    private int valueDamage;

    @Column(name = "diceDamage")
    private int diceDamage;

    @Column(name = "mod")
    private int mod;

    @Column(name = "weight")
    private int weight;

    @Column(name = "military")
    private boolean military;

    @Column(name = "longRange")
    private boolean longRange;

    @Column(name="properies")
    @OneToMany
    @CollectionTable(name = "weapon_property", joinColumns = @JoinColumn(name = "weapon_id"))
    private Set<WeaponProperties> weaponPropertiesSet;

    public Weapon(String name, int price, int valueDamage, int diceDamage, int mod, int weight, boolean military, boolean longRange) {
        this.name = name;
        this.price = price;
        this.valueDamage = valueDamage;
        this.diceDamage = diceDamage;
        this.mod = mod;
        this.weight = weight;
        this.military = military;
        this.longRange = longRange;
    }
}
