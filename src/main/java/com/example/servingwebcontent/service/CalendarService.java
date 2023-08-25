package com.example.servingwebcontent.service;

import com.example.servingwebcontent.dto.entity.Game;
import com.example.servingwebcontent.dto.entity.System;
import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.exception.ExistInfoException;
import com.example.servingwebcontent.exception.NoInfoException;
import com.example.servingwebcontent.repos.GameRepos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    @Autowired
    GameRepos gameRepos;

    @Autowired
    ObjectMapper objectMapper;

    public ResponseEntity<?> mainPage(){
        List<Game> games = gameRepos.findAll();
        return ResponseEntity.ok(games);
    }

    public ResponseEntity<?> gameDescription(Long gameId){
        return ResponseEntity.ok(gameRepos.findById(gameId));
    }

    @Transactional
    public ResponseEntity<?> gameDelete(Long gameId){
        Optional<Game> gameOptional = gameRepos.findById(gameId);
        Game game = gameOptional.orElse(null); // Можно использовать orElseThrow но только понять как реализовать
        gameRepos.delete(game);
        List<Game> games = gameRepos.findAll();
        return ResponseEntity.ok(games);
    }

    public ResponseEntity<?> gameFilter(String filter){
        if(filter != null && !filter.isEmpty()){
            if(gameRepos.findByName(filter)==null){
                throw new EntityNotFoundException("No such game exists");
            } else {
                return ResponseEntity.ok(gameRepos.findByName(filter));
            }
        } else {
            return ResponseEntity.ok(gameRepos.findAll());
        }
    }

    @Transactional
    public ResponseEntity<?> gameAdd(String gameInfo){
        //TODO Как-то сделать лучше и читабельнее, мб свой ExceptionClass
        Game game;
        try {
            //TODO Проверить на передачу System, Date и Time
            game = objectMapper.readValue(gameInfo, Game.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(game.getName()==""){
            throw new NoInfoException("Please, enter game name");
        }
        if(gameRepos.findByName(game.getName())!=null){
            throw new ExistInfoException("Game with a similar name already exists");
        }
        //TODO Изменить проверку System, стоит убрать стартовое значение Game
        if (game.getSystem().equals(System.Game)){
            throw new NoInfoException("Please, enter game system");
        }
        gameRepos.save(game);
        return ResponseEntity.ok(gameRepos.findAll());
    }

    @Transactional
    public ResponseEntity<?> userRegistration(String gameId, User user){
        Optional<Game> gameOptional;

        try {
            gameOptional = gameRepos.findById(objectMapper.readTree(gameId).get("gameId").asLong());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        };

        Game game = gameOptional.orElse(null);
        if(gameId==""){
            throw new NoInfoException("There is no game Id");
        }
        for (User usr : game.getSubscribers()){
            if (usr.getId().equals(user.getId())){
                throw new NoInfoException("You are already registered to this game");
            }
        }
        game.getSubscribers().add(user);
        gameRepos.save(game);
        return ResponseEntity.ok(gameRepos.findAll());
    }
}
