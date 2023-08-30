package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.dnd.characters.DHNumber;
import com.example.servingwebcontent.logic.Randomizer;
import com.example.servingwebcontent.repos.dnd.NumberRepos;
import com.example.servingwebcontent.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiceController {
    @Autowired
    DiceService diceService;
    @GetMapping("/dice")
    public ResponseEntity<?> main(Model model){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dice")
    public ResponseEntity<?> randDice(@RequestBody String diceInfo){
        //Сюда поступает JSON
        return diceService.rollDice(diceInfo);
    }


}
