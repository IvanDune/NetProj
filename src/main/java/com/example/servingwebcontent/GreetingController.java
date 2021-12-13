package com.example.servingwebcontent;

import com.example.servingwebcontent.domain.UserDAO;
import com.example.servingwebcontent.repos.UserDAORepos;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private UserDAORepos userDAORepos;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<UserDAO> users = userDAORepos.findAll();
        model.put("users",users);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String login, @RequestParam String password,
                      @RequestParam String nickname, @RequestParam String email, Map<String, Object> model){
        UserDAO userDAO = new UserDAO(login,password,nickname,email);
        userDAORepos.save(userDAO);
        Iterable<UserDAO> users = userDAORepos.findAll();
        model.put("users",users);
        return "main";
    }

}