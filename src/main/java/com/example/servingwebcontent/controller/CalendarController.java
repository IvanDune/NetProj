package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.repos.GameRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalendarController {
    @Autowired
    private GameRepos gameRepos;

    @GetMapping("calendar")
    public String main(Map<String,Object> model){
        Iterable<Game> games = gameRepos.findAll();
        model.put("games", games);
        return "calendar";
    }

    @PostMapping("/calendar")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable<Game> games;
        if(filter != null && !filter.isEmpty()){
            games = gameRepos.findByName(filter);
        } else {
            games = gameRepos.findAll();
        }
        model.put("games", games);
        return "calendar";
    }

    @PostMapping("/calendar/add")
    public String add(){

        return "calendar";
    }
}
