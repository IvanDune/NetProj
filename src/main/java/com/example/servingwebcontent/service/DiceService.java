package com.example.servingwebcontent.service;

import com.example.servingwebcontent.dto.DiceDTO;
import com.example.servingwebcontent.dto.dnd.characters.DHNumber;
import com.example.servingwebcontent.logic.Randomizer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;

@Service
public class DiceService {
    @Autowired
    ObjectMapper objectMapper;
    public ResponseEntity<?> rollDice(String diceInfo){
        DiceDTO diceDTO;
        try {
            diceDTO = objectMapper.readValue(diceInfo,DiceDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(Randomizer.rand(
                diceDTO.getDice(),diceDTO.getModDice(),diceDTO.getNumDice()));// Можно переделать под встроенный метод DTO
        //numberRepos.save(new DHNumber(result-modDice)); - ненужная статистика
    }
}
