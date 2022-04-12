package com.example.servingwebcontent.domain.dnd.characters;

import org.springframework.security.core.GrantedAuthority;

public enum CharacteristicBuff  {
    STR_ONE (1),
    STR_TWO (2),
    DEX_ONE (1),
    DEX_TWO (2),
    CON_ONE (1),
    CON_TWO (2),
    WIS_ONE (1),
    WIS_TWO (2),
    INT_ONE (1),
    INT_TWO (2),
    CHA_ONE (1),
    CHA_TWO (2);

    private int mod;

    CharacteristicBuff(int mod){
        this.mod=mod;
    }
}
