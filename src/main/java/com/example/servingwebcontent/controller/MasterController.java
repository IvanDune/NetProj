package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Message;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    MessageRepos messageRepos;

    @GetMapping
    public String main(Model model){
        Iterable<Message> messages = messageRepos.findAll();
        model.addAttribute("messages",messages);
        return "master";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String mess,
            @RequestParam Integer number, Model model){
        Message message = new Message(mess,user,number);
        messageRepos.save(message);
        Iterable<Message> messages = messageRepos.findAll();
        model.addAttribute("messages",messages);
        return "master";
    }
}
