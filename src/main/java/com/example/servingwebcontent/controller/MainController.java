package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.entity.Role;
import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.geom.RectangularShape;
import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    UserService userService;

    @GetMapping("/main")
    public ResponseEntity<?> main(@AuthenticationPrincipal User user){
        //Раньше передавался @Authentication User user
        return ResponseEntity.ok().build(); }

    @PostMapping("/main")
    public ResponseEntity<?> addUser(@RequestBody String userInfo){
        return userService.addUser(userInfo);
    }

}