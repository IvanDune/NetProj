package com.example.servingwebcontent.dto.dnd.characters;

import javax.persistence.*;
import java.util.Set;

@Entity
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

    public Spell(){

    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public SpellCastingTime getSpellCastingTime() {
        return spellCastingTime;
    }

    public void setSpellCastingTime(SpellCastingTime spellCastingTime) {
        this.spellCastingTime = spellCastingTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<ClassEnum> getClassEnumSet() {
        return classEnumSet;
    }

    public void setClassEnumSet(Set<ClassEnum> classEnumSet) {
        this.classEnumSet = classEnumSet;
    }
}
