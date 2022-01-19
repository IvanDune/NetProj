package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserRepos userRepos;

    @GetMapping
    public String main(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping
    public String save(
            @RequestParam String login, @RequestParam String nickname,
            @RequestParam String email, @RequestParam("userId") User user,
            Model model){
        if(userRepos.findByLogin(login)!=null){
            model.addAttribute("message", "Login already in use");
            return "profile";
        }
        user.setLogin(login);
        user.setNickname(nickname);
        user.setEmail(email);
        userRepos.save(user);
        return "/main";
    }
}
