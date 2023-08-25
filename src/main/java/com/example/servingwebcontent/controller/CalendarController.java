package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.repos.GameRepos;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalendarController {
    @Autowired
    private CalendarService calendarService;
    @GetMapping("/calendar")
    public ResponseEntity<?> main(@AuthenticationPrincipal User user, Model model){
        //TODO Раньше передавался @Authentication User user
        return calendarService.mainPage();
    }

    @GetMapping("/calendar/{gameId}")
    public ResponseEntity<?> gameDescription(@PathVariable Long gameId){
        return calendarService.gameDescription(gameId);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteGame(@RequestBody Long gameId){
        //Раньше передавался @Authentication User user
        //Должна быть информация об успешной операции
        return calendarService.gameDelete(gameId);
    }

    @PostMapping("/calendar")
    public ResponseEntity<?> filter(@RequestBody String filter){//Здесь просто строка
        //Раньше передавался @Authentication User user
        return calendarService.gameFilter(filter);
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @PostMapping("/add")
    public ResponseEntity<?> addGame(@RequestBody String gameInfo){//Здесь JSON
        //Раньше передавался @Authentication User user
        //Должна быть информация об успешной операции
        return calendarService.gameAdd(gameInfo);
    }

    @PostMapping("/note")
    public ResponseEntity<?> userRegistration(@AuthenticationPrincipal User user, @RequestBody String gameId){
        //Должна быть информация об успешной операции
        return calendarService.userRegistration(gameId,user);
    }




}
