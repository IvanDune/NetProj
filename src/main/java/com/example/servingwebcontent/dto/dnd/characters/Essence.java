package com.example.servingwebcontent.dto.dnd.characters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
public abstract class Essence  {
    protected String name;

    protected int HP;

    protected int baseAC=10;

    protected int initiative;

}
