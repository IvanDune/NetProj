package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.dnd.characters.Character;
import com.example.servingwebcontent.domain.dnd.characters.Characteristics;
import com.example.servingwebcontent.domain.dnd.characters.DHNumber;
import com.example.servingwebcontent.domain.dnd.characters.Race;
import com.example.servingwebcontent.repos.dnd.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class StatController {
    @Autowired
    CharacteristicRepos characteristicRepos;

    @Autowired
    RaceRepos raceRepos;

    @Autowired
    ChaClassRepos chaClassRepos;

    @Autowired
    NumberRepos numberRepos;

    @Autowired
    CharacterRepos characterRepos;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/stat")
    public String stat(Model model) {
        List<DHNumber> numbers = numberRepos.findAll();
        OptionalDouble aver = numbers.stream().mapToInt(DHNumber::getNum).average();
        model.addAttribute("average", aver);

        Map<String,Integer> races = new HashMap<>();
        races.put("Strength", 0);
        races.put("Dexterity", 0);
        races.put("Constitution", 0);
        races.put("Intelligence", 0);
        races.put("Wisdom", 0);
        races.put("Charisma", 0);
        for(Character character : characterRepos.findAll()){
            if (races.containsKey(character.getRaceName())){
                int i = races.get(character.getRaceName());
                races.put(character.getRaceName(),++i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        races.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(s->stringBuilder.append(s.getKey()).append(": ").append(s.getValue()).append("\n"));
        model.addAttribute("race",stringBuilder);

        return "stat";
    }
}
