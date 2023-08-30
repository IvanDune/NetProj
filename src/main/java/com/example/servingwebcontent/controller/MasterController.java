package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.dto.entity.Review;
import com.example.servingwebcontent.dto.entity.Role;
import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.repos.ReviewRepos;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/master")
public class MasterController {
    @Autowired
    UserRepos userRepos;

    @Autowired
    ReviewRepos reviewRepos;

    @Autowired
    MasterService masterService;

    @GetMapping
    public ResponseEntity<?> main(@AuthenticationPrincipal User user){
        return masterService.mainPage(user);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody String messageInfo, @AuthenticationPrincipal User user){
        return masterService.addMessage(messageInfo,user);
    }

}
