package com.example.servingwebcontent.service;

import com.example.servingwebcontent.dto.dnd.characters.Character;
import com.example.servingwebcontent.dto.entity.Role;
import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.exception.ExistInfoException;
import com.example.servingwebcontent.exception.NoInfoException;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.repos.dnd.CharacterRepos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepos userRepos;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CharacterRepos characterRepos;


    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userRepos.findAll());
    }

    public ResponseEntity<?> userInfo(String userId){
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(userId);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        long id = jsonNode.get("id").asLong();
        return ResponseEntity.ok(userRepos.findById(id));
    }

    public ResponseEntity<?> characterInfo(String characterUserInfo){
        //TODO Раньше выдавалась информация о расе, классе и персонаже, теперь только персонаж
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(characterUserInfo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        long userId = jsonNode.get("userId").asLong();
        long characterId = jsonNode.get("characterId").asLong();

        return ResponseEntity.ok(characterRepos.findById(characterId));

    }

    public ResponseEntity<?> filter(String filter){
        if (filter != null && !filter.isEmpty()){
            User user = userRepos.findByNickname(filter);
            if (user==null){
                throw new NoInfoException("This user does not exist");
            } else{
                return ResponseEntity.ok(user);
            }
        } else{
            return ResponseEntity.ok(userRepos.findAll());
        }
    }

//    public ResponseEntity<?> userProfile(User user){
//        User usr = userRepos.findById(user.getId());
//        Iterable<Character> characters = user1.getCharacters();
//        model.addAttribute("games", user1.getSubscriptions());
//        model.addAttribute("user", user1);
//        model.addAttribute("nickname", user1.getNickname());
//        model.addAttribute("email", user1.getEmail());
//        model.addAttribute("characters",characters);
//
//    }

    @Transactional
    public void saveChangedUser(User user, Map<String, String> form){
        //Clear all roles target user
        user.getRoles().clear();
        //Go through form roles and add them to user
        for(String key : form.keySet()){
            if (key.equals("ADMIN")){
                user.getRoles().add(Role.valueOf("ADMIN"));
                user.getRoles().add(Role.valueOf("MASTER"));
            }
            if (key.equals("MASTER")){
                user.getRoles().add(Role.valueOf("MASTER"));
            }
            if (key.equals("USER")){
                user.getRoles().add(Role.valueOf("USER"));
            }
        }
        //Save user
        userRepos.save(user);
    }
    public ResponseEntity<?> addUser(String userInfo) {
        User user = null;
        try {
            user = objectMapper.readValue(userInfo, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(userRepos.findById(user.getId())!=null){
            throw new ExistInfoException("Such user already exists in the database");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);
        return ResponseEntity.ok().build();
    }

    public void updateProfile(User user, String nickname, String email) {
        //Check null email after update
        boolean isEmailChanged = (email != null);
        if (isEmailChanged)
            user.setEmail(email);
        user.setNickname(nickname);
        userRepos.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepos.findByLogin(login);
    }
}
