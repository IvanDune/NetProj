package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.System;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.GameRepos;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Controller
public class CalendarController {
    @Autowired
    private GameRepos gameRepos;

    @Autowired
    private UserRepos userRepos;

    @GetMapping("calendar")
    public String main(Map<String,Object> model){
        Iterable<Game> games = gameRepos.findAll();
        model.put("games", games);
        return "calendar";
    }

    @PostMapping("/calendar")
    public String filter(
            @RequestParam(defaultValue = "") String filter,
            Map<String,Object> model){
        Iterable<Game> games;
        if(filter != null && !filter.isEmpty()){
            games = gameRepos.findByName(filter);
        } else {
            games = gameRepos.findAll();
        }
        model.put("games", games);
        model.put("filter", filter);
        return "calendar";
    }

    @PostMapping("/add")
    public String addGame(@RequestParam String name, @RequestParam String description,
                          @RequestParam System system, @RequestParam String discord, @RequestParam String date, @RequestParam String time, Map<String,Object> model){

        Iterable<Game> gameFromDb = gameRepos.findByName(name);
        Iterable<Game> games = gameRepos.findAll();
        if(gameFromDb != null && gameFromDb.iterator().hasNext()){
            model.put("message", "Game with a similar name already exists");
            model.put("games", games);
            return"calendar";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date2=null;
        try {
            date2 = dateFormat.parse(date+" "+time);
        } catch (ParseException e) {
            model.put("message", "Inappropriate date format");
            model.put("games", games);
            return"calendar";
        }
        gameRepos.save(new Game(name,description,system,discord,date2));
        return "redirect:/calendar";
    }
}
