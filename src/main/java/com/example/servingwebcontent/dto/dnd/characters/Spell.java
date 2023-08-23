package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="spell")
@Getter
@Setter
@NoArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "school")
    private String school;

    @Column(name = "spellCastingTime")
    @Enumerated(EnumType.STRING)
    private SpellCastingTime spellCastingTime;

    @Column(name = "range")
    private String range;

    @Column(name = "components")
    private String components;

    @Column(name = "Duration")
    private String duration;

    @Column(name="classes")
    @ElementCollection(targetClass = ClassEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "spell_classes", joinColumns = @JoinColumn(name = "spell_id"))
    @Enumerated(EnumType.STRING)
    private Set<ClassEnum> classEnumSet;

    public Spell(String name, int level, String school, SpellCastingTime spellCastingTime, String range, String components, String duration, Set<ClassEnum> classEnumSet) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.spellCastingTime = spellCastingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.classEnumSet = classEnumSet;
    }
}
