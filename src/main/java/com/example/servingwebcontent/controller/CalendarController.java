package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.domain.System;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.GameRepos;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class    CalendarController {
    @Autowired
    private GameRepos gameRepos;

    @Autowired
    private UserRepos userRepos;

    @GetMapping("calendar")
    public String main(@AuthenticationPrincipal User user, Model model){
        Iterable<Game> games = gameRepos.findAll();
        Long gameSize = gameRepos.count();
        model.addAttribute("gameSize", gameSize);
        model.addAttribute("userChannel",user);
        model.addAttribute("games", games);

        return "calendar";
    }

    @PostMapping("/calendar")
    public String filter(
            @RequestParam(defaultValue = "") String filter,
            @AuthenticationPrincipal User userChannel,
            Model model){
        Game games;
        if(filter != null && !filter.isEmpty()){
            if(gameRepos.findByName(filter)==null){
                model.addAttribute("games", gameRepos.findAll());
                model.addAttribute("messageEr","No such game exists");
            } else {
                List<Game> gameList = new ArrayList<>();
                gameList.add(gameRepos.findByName(filter));
                model.addAttribute("games", gameList);
            }
        } else {
            model.addAttribute("games", gameRepos.findAll());
        }
        Long gameSize = gameRepos.count();
        model.addAttribute("gameSize", gameSize);
        model.addAttribute("userChannel", userChannel);
        model.addAttribute("filter", filter);
        return "calendar";
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @PostMapping("/add")
    public String addGame(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam System system,
                          @RequestParam String discord,
                          @RequestParam String date,
                          @RequestParam String time,
                          @AuthenticationPrincipal User userChannel,
                          Model model){

        Game gameFromDb = gameRepos.findByName(name);
        Iterable<Game> games = gameRepos.findAll();

        model.addAttribute("games", games);
        model.addAttribute("userChannel", userChannel);
        Long gameSize = gameRepos.count();
        model.addAttribute("gameSize", gameSize);

        if(name==""){
            model.addAttribute("messageError","Please, enter game name");
            return "calendar";
        }
        if(gameFromDb != null){
            model.addAttribute("messageError", "Game with a similar name already exists");
            return"calendar";
        }

        if (system == System.Game){
            model.addAttribute("messageError", "Please, enter game system");
            return"calendar";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date2=null;
        try {
            date2 = dateFormat.parse(date+" "+time);
        } catch (ParseException e) {
            model.addAttribute("messageError", "Inappropriate date format");
            return"calendar";
        }
        gameRepos.save(new Game(name,description,system,discord,date2));
        return "redirect:/calendar";
    }

    @PostMapping("/note")
    public String userRegistration(@AuthenticationPrincipal User user,
                                   @RequestParam String game,
                                   Model model){
        Iterable<Game> games = gameRepos.findAll();
        Long gameSize = gameRepos.count();
        model.addAttribute("gameSize", gameSize);
        model.addAttribute("userChannel",user);
        model.addAttribute("games", games);


        Game game1 = gameRepos.findByName(game);
        if(game==""){
            model.addAttribute("message","Please, enter game name");
            return "/calendar";
        }
        for (User usr : game1.getSubscribers()){
            if (usr.getLogin().equals(user.getLogin())){
                model.addAttribute("messageEr", "You are already registered to this game");
                return "/calendar";
            }
        }

        game1.getSubscribers().add(user);
        model.addAttribute("message", "Have a good game");


        gameRepos.save(game1);
        return "/calendar";
    }

    @PostMapping("delete")
    public String deleteGame(@RequestParam String game,
                             @AuthenticationPrincipal User userChannel,
                             Model model){

        Game game1 = gameRepos.findByName(game);
        gameRepos.delete(game1);
        Iterable<Game> games = gameRepos.findAll();

        Long gameSize = gameRepos.count();
        model.addAttribute("gameSize", gameSize);
        model.addAttribute("userChannel", userChannel);
        model.addAttribute("games", games);
        return "calendar";
    }

    @GetMapping("/calendar/{game}")
    public String gameDescription(@PathVariable Game game,
            Model model){
        model.addAttribute("game",game);
        return "descGame";
    }
}
