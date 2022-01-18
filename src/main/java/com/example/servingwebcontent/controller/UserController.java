package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepos userRepos;

    @GetMapping
    public String filter(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        User users;
        if (filter != null && !filter.isEmpty()){
            users = userRepos.findByLogin(filter);
            model.addAttribute("users", users);
        } else{
            model.addAttribute("users", userRepos.findAll());
        }
        model.addAttribute("filter", filter);

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String add(@RequestParam String login, @RequestParam String password,
                      @RequestParam String nickname, @RequestParam String email, Model model){

        User user = new User(login,password,nickname,email);
        User userFromDb = userRepos.findByLogin(user.getLogin());//Заменить на поиск по уникальному логину

        if (userFromDb != null){
            model.addAttribute("message", "User exist");
            return "redirect:/user";//Ошбика в возвращении страницы
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);

        Iterable<User> users = userRepos.findAll();
        model.addAttribute("users",users);
        return "redirect:/user";
    }

    @PostMapping("{user}")
    public String userSave(
            @RequestParam String login,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){
        user.setLogin(login);
        Set<String> roles = Arrays.stream(Role.values())
                        .map(Role::name)
                        .collect(Collectors.toSet());
        user.getRoles().clear();
        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepos.save(user);
        return "redirect:/user";
    }

}
