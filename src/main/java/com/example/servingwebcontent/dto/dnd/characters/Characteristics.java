package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
@Entity
@Table(name="characteristic")
@Getter
@Setter
@NoArgsConstructor
public class Characteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "essence_id")
    private Long essenceId;

    @Column(name="strength")
    private int strength;

    @Column(name="strengthMod")
    private int strengthMod;

    @Column(name="dexterity")
    private int dexterity;

    @Column(name="dexterityMod")
    private int dexterityMod;

    @Column(name="constitution")
    private int constitution;

    @Column(name="constitutionMod")
    private int constitutionMod;

    @Column(name="wisdom")
    private int wisdom;

    @Column(name="wisdomMod")
    private int wisdomMod;

    @Column(name="intelligence")
    private int intelligence;

    @Column(name="intelligenceMod")
    private int intelligenceMod;

    @Column(name="charisma")
    private int charisma;

    @Column(name="charismaMod")
    private int charismaMod;

    public Characteristics(int strength, int strengthMod,
                           int dexterity, int dexterityMod, int constitution,
                           int constitutionMod, int wisdom, int wisdomMod,
                           int intelligence, int intelligenceMod, int charisma,
                           int charismaMod) {
        this.strength = strength;
        this.strengthMod = strengthMod;
        this.dexterity = dexterity;
        this.dexterityMod = dexterityMod;
        this.constitution = constitution;
        this.constitutionMod = constitutionMod;
        this.wisdom = wisdom;
        this.wisdomMod = wisdomMod;
        this.intelligence = intelligence;
        this.intelligenceMod = intelligenceMod;
        this.charisma = charisma;
        this.charismaMod = charismaMod;
    }
}
