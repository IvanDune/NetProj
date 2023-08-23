package com.example.servingwebcontent.dto.dnd.characters;

public class Enemy extends Essence{

    public Enemy(String name, int HP, int baseAC, int initiative) {
        this.name = name;
        this.HP = HP;
        this.baseAC = baseAC;
        this.initiative = initiative;
    }


}

