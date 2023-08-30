package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.entity.GameSystem;
import com.example.servingwebcontent.repos.GameSystemRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameSystemController {
    @Autowired
    GameSystemRepos gameSystemRepos;
    @GetMapping("/gamesystem")
    public String main(Model model){
        Iterable<GameSystem> gameSystems = gameSystemRepos.findAll();
        model.addAttribute("gameSystems", gameSystems);
        return "gameSystem";
    }
}
