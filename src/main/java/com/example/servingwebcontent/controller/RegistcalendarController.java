package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.domain.System;
import com.example.servingwebcontent.repos.GameRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class RegistcalendarController {
    @Autowired
    private GameRepos gameRepos;

    @GetMapping("/registcalendar")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registcalendar")
    public String addGame(@RequestParam String name, @RequestParam String description,
                            @RequestParam System system, @RequestParam String discord, Map<String,Object> model){

        Iterable<Game> gameFromDb = gameRepos.findByName(name);
        if(gameFromDb != null && gameFromDb.iterator().hasNext()){
            model.put("game", "Game with a similar name already exists");
            return"/registcalendar";
        }
        gameRepos.save(new Game(name,description,system,discord));
        return "redirect:/calendar";
    }
}
