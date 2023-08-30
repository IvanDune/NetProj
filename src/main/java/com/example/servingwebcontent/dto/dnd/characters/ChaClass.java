package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;import java.util.Set;

@Entity
@Table(name="character_class")
@Getter
@Setter
@NoArgsConstructor
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

    @Column(name="armors")
    @ElementCollection(targetClass = ProficienciesArmor.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_armors", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesArmor> pro_armor;

    @Column(name="skills")
    @ElementCollection(targetClass = ProficienciesSkills.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_skills", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesSkills> pro_skills;

    @Column(name="tools")
    @ElementCollection(targetClass = ProficienciesTools.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_tools", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesTools> pro_tools;

    @Column(name="weapons")
    @ElementCollection(targetClass = ProficienciesWeapon.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_weapon", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProficienciesWeapon> pro_weapon;

    @Column(name="abilities")
    @OneToMany
    @CollectionTable(name = "class_abilities", joinColumns = @JoinColumn(name = "class_id"))
    private Set<ClassAbility> classAbilitySet;

    public ChaClass(String name, String description, int hitDice) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
    }

    public ChaClass(String name, String description, int hitDice, Set<ProficienciesSaves> pro_saves,
                    Set<ProficienciesArmor> pro_armor, Set<ProficienciesSkills> pro_skills, Set<ProficienciesTools> pro_tools,
                    Set<ProficienciesWeapon> pro_weapon, Set<ClassAbility> classAbilitySet) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.pro_saves = pro_saves;
        this.pro_armor = pro_armor;
        this.pro_skills = pro_skills;
        this.pro_tools = pro_tools;
        this.pro_weapon = pro_weapon;
        this.classAbilitySet = classAbilitySet;
    }
}
