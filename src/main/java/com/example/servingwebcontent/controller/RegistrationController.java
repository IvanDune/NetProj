package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String nickname,
            @RequestParam String email,
            User user, Model model ){
        if (userRepos.findByLogin(username) != null){
            model.addAttribute("user", "User exist");
            return "/registration";
        }
        if (username == "") {
            model.addAttribute("user", "Please, enter username");
            return "/registration";
        }
        if (password == ""){
            model.addAttribute("user", "Please, enter password");
            return "/registration";
        }
        if (nickname == ""){
            model.addAttribute("user", "Please, enter nickname");
            return "/registration";
        }
        if (email == ""){
            model.addAttribute("user", "Please, enter email");
            return "/registration";
        }

        User userDb = new User(username, password,nickname,email);
        userDb.setActive(true);
        userDb.setRoles(Collections.singleton(Role.USER));
        userDb.setPassword(passwordEncoder.encode(userDb.getPassword()));
        userRepos.save(userDb);
        return "redirect:/login";
    }

}
