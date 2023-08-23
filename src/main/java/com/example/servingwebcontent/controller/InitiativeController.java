package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.dnd.characters.Enemy;
import com.example.servingwebcontent.dto.dnd.characters.Essence;
import com.example.servingwebcontent.logic.Randomizer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/game")
public class InitiativeController {
    List<Essence> essenceList = new ArrayList<>();

    @GetMapping
    public String main(Model model){
        essenceList.sort(Comparator.comparing(Essence::getInitiative).reversed());
        model.addAttribute("essencesSize", essenceList.size());
        model.addAttribute("essences", essenceList);
        return "init";
    }

    @PostMapping()
    public String createEssence(@RequestParam String nameEssence, @RequestParam int hpEssence,
                                @RequestParam int acEssence, @RequestParam int initEssence,
                                Model model){
        essenceList.add(new Enemy(nameEssence, hpEssence, acEssence,initEssence));
        return "redirect:/game";
    }

    @PostMapping("/refactor")
    public String deleteAllPlayersInitiative(){
        essenceList.clear();
        return "redirect:/game";
    }

    @PostMapping("/dice")
    public String randDice(@RequestParam int numDice, @RequestParam int modDice,
                           @RequestParam int dice, Model model){
        int result = Randomizer.rand(dice,modDice,numDice);
        model.addAttribute("answer",result);
        model.addAttribute("essencesSize", essenceList.size());
        model.addAttribute("essences", essenceList);
        return "init";
    }
}
