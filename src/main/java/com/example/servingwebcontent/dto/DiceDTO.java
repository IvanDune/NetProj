package com.example.servingwebcontent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiceDTO {
    private int numDice=0;

    private int modDice=0;

    private int dice=0;
}
