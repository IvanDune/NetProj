package com.example.servingwebcontent.dto.dnd.characters;

public enum ProficienciesSkills {
    ACROBATICS(ProficienciesSaves.DEXTERITY),
    ANIMAL_HANDLING(ProficienciesSaves.WISDOM),
    ARCANA(ProficienciesSaves.INTELLIGENCE),
    ATHLETICS(ProficienciesSaves.STRENGTH),
    DECEPTION(ProficienciesSaves.CHARISMA),
    HISTORY(ProficienciesSaves.INTELLIGENCE),
    INSIGHT(ProficienciesSaves.WISDOM),
    INTIMIDATION(ProficienciesSaves.CHARISMA),
    INVESTIGATION(ProficienciesSaves.INTELLIGENCE),
    MEDICINE(ProficienciesSaves.WISDOM),
    NATURE(ProficienciesSaves.INTELLIGENCE),
    PERCEPTION(ProficienciesSaves.WISDOM),
    PERFORMANCE(ProficienciesSaves.CHARISMA),
    PERSUASION(ProficienciesSaves.CHARISMA),
    RELIGION(ProficienciesSaves.INTELLIGENCE),
    SLEIGHT_OF_HAND(ProficienciesSaves.DEXTERITY),
    STEALTH(ProficienciesSaves.DEXTERITY),
    SURVIVAL(ProficienciesSaves.WISDOM);

    private ProficienciesSaves ch;

    ProficienciesSkills(ProficienciesSaves ch){
        this.ch=ch;
    }
}
