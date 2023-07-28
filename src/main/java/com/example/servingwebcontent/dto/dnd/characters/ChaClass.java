package com.example.servingwebcontent.dto.dnd.characters;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChaClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="hitDice")
    private int hitDice;

    @Column(name="saves")
    @ElementCollection(targetClass = ProficienciesSaves.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_saves", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesSaves> pro_saves;

    @Column(name="saves")
    @ElementCollection(targetClass = ProficienciesArmor.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_armors", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesArmor> pro_armor;

    @Column(name="saves")
    @ElementCollection(targetClass = ProficienciesSkills.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_skills", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesSkills> pro_skills;

    @Column(name="saves")
    @ElementCollection(targetClass = ProficienciesTools.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_tools", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesTools> pro_tools;

    @Column(name="saves")
    @ElementCollection(targetClass = ProficienciesWeapon.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_weapon", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesWeapon> pro_weapon;

    @Column(name="abilities")
    @OneToMany
    @CollectionTable(name = "class_ability", joinColumns = @JoinColumn(name = "class_id"))
    private Set<ClassAbilities> classAbilitiesSet;

    public ChaClass(){

    }

    public ChaClass(String name, String description, int hitDice) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
    }

    public ChaClass(String name, String description, int hitDice, Set<ProficienciesSaves> pro_saves,
                    Set<ProficienciesArmor> pro_armor, Set<ProficienciesSkills> pro_skills, Set<ProficienciesTools> pro_tools,
                    Set<ProficienciesWeapon> pro_weapon, Set<ClassAbilities> classAbilitiesSet) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.pro_saves = pro_saves;
        this.pro_armor = pro_armor;
        this.pro_skills = pro_skills;
        this.pro_tools = pro_tools;
        this.pro_weapon = pro_weapon;
        this.classAbilitiesSet = classAbilitiesSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public Set<ProficienciesSaves> getPro_saves() {
        return pro_saves;
    }

    public void setPro_saves(Set<ProficienciesSaves> pro_saves) {
        this.pro_saves = pro_saves;
    }

    public Set<ProficienciesArmor> getPro_armor() {
        return pro_armor;
    }

    public void setPro_armor(Set<ProficienciesArmor> pro_armor) {
        this.pro_armor = pro_armor;
    }

    public Set<ProficienciesSkills> getPro_skills() {
        return pro_skills;
    }

    public void setPro_skills(Set<ProficienciesSkills> pro_skills) {
        this.pro_skills = pro_skills;
    }

    public Set<ProficienciesTools> getPro_tools() {
        return pro_tools;
    }

    public void setPro_tools(Set<ProficienciesTools> pro_tools) {
        this.pro_tools = pro_tools;
    }

    public Set<ProficienciesWeapon> getPro_weapon() {
        return pro_weapon;
    }

    public void setPro_weapon(Set<ProficienciesWeapon> pro_weapon) {
        this.pro_weapon = pro_weapon;
    }

    public Set<ClassAbilities> getClassAbilitiesSet() {
        return classAbilitiesSet;
    }

    public void setClassAbilitiesSet(Set<ClassAbilities> classAbilitiesSet) {
        this.classAbilitiesSet = classAbilitiesSet;
    }
}
