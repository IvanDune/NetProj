package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<User> users = userRepos.findAll();
        model.put("users",users);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String login, @RequestParam String password,
                      @RequestParam String nickname, @RequestParam String email, Map<String, Object> model){
        User user = new User(login,password,nickname,email);
        userRepos.save(user);
        Iterable<User> users = userRepos.findAll();
        model.put("users",users);
        return "main";
    }
    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<User> users;
        if (filter != null && !filter.isEmpty()){
            users = userRepos.findByNickname(filter);
        } else{
            users = userRepos.findAll();
        }

        model.put("users", users);
        return "main";
    }
}