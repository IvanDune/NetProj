package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.dnd.characters.DHNumber;
import com.example.servingwebcontent.logic.Randomizer;
import com.example.servingwebcontent.repos.dnd.NumberRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @Autowired
    NumberRepos numberRepos;

    @GetMapping("/dice")
    public String main(Model model){
        return "dices";
    }

    @PostMapping("/dice")
    public String randDice(@RequestParam int numDice, @RequestParam int modDice,
                           @RequestParam int dice, Model model){
        int result = Randomizer.rand(dice,modDice,numDice);
        numberRepos.save(new DHNumber(result-modDice));
        model.addAttribute("answer",result);
        return "dices";
    }


}
