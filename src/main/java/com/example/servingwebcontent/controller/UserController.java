package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String filter(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        UserDetails users;
        if (filter != null && !filter.isEmpty()){
            users = userService.loadUserByUsername(filter);
            model.addAttribute("users", users);
        } else{
            model.addAttribute("users", userService.findAll());
        }
        model.addAttribute("roles", Role.values());
        model.addAttribute("filter", filter);

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String add(@RequestParam String login, @RequestParam String password,
                      @RequestParam String nickname, @RequestParam String email,
                      @RequestParam Map<String, String> form, Model model){

        User user = new User(login,password,nickname,email);
        UserDetails userFromDb = userService.loadUserByUsername(user.getLogin());

        if (userFromDb != null){
            model.addAttribute("message", "User exist");
            return "redirect:/user";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(user);

        model.addAttribute("users",userService.findAll());
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("{user}")
    public String userSave(
            @RequestParam String login,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){

        userService.saveChangedUser(user, login, form);
        return "redirect:/user";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("email", user.getEmail());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String nickname,
            @RequestParam String email
    ){
        userService.updateProfile(user, password, nickname, email);
        return "redirect:/user/profile";
    }

}
