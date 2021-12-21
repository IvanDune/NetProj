package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepos userRepos;

    @GetMapping("/registrtion")
    public String registration(){
        return "registrattion";
    }


    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model ){
        Iterable<User> userFromDb = userRepos.findByNickname(user.getNickname());
        if (userFromDb != null && userFromDb.iterator().hasNext()){
            model.put("user", "User exist");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);
        return "redirect:/login";
    }

}