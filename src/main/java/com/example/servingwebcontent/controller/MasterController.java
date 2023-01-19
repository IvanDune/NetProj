package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Review;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.ReviewRepos;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    UserRepos userRepos;

    @Autowired
    ReviewRepos reviewRepos;

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){
        List masters = new ArrayList<>();
        for (User usr : userRepos.findAll()){
            if(usr.getRoles().contains(Role.MASTER)){
                masters.add(usr);
            }
        }
        Collections.sort(masters);
        model.addAttribute("masters",masters);
        model.addAttribute("userChannel",user);

        return "master";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam Integer gr,
            @RequestParam String mess,
            @RequestParam String masterLogin, Model model){
        if(gr==null){
            List<User> masters = new ArrayList<>();
            for (User usr : userRepos.findAll()){
                if(usr.getRoles().contains("MASTER")){
                    masters.add(usr);
                }
            }
            model.addAttribute("masters",masters);
            model.addAttribute("userChannel",user);
            model.addAttribute("noMessage", "Enter your grade");

            return "master";
        }
        if (mess==""){
            List<User> masters = new ArrayList<>();
            for (User usr : userRepos.findAll()){
                if(usr.getRoles().contains("MASTER")){
                    masters.add(usr);
                }
            }
            model.addAttribute("masters",masters);
            model.addAttribute("userChannel",user);
            model.addAttribute("noMessage", "Enter your review and grade");

            return "master";
        }

        Review review = new Review(mess, gr, masterLogin,user.getLogin());
        reviewRepos.save(review);

        User usr = userRepos.findByLogin(masterLogin);
        usr.changeVote(review);


        userRepos.save(usr);


        return "redirect:/master";
    }

}
