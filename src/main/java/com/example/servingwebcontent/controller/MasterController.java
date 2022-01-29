package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Grade;
import com.example.servingwebcontent.domain.Message;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.GradeRepos;
import com.example.servingwebcontent.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    MessageRepos messageRepos;

    @Autowired
    GradeRepos gradeRepos;

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){
        Iterable<Message> messages = messageRepos.findAll();
        model.addAttribute("messages",messages);

        Set<Integer> exist = new HashSet<>();
        for (Message mes : messageRepos.findByAuthor(user.getLogin()))
            exist.add(mes.getNumber());

//        int i =1;
        String s = "";
        for (Grade gr : gradeRepos.findAll()){
            s = "grade" + gr.getMasterNumber();
//            i++;
            model.addAttribute(s, gr.getMean());
        }

        model.addAttribute("exist1", exist.contains(1));
        model.addAttribute("exist2", exist.contains(2));
        model.addAttribute("exist3", exist.contains(3));
        model.addAttribute("exist4", exist.contains(4));

        return "master";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam Integer gr,
            @RequestParam String mess,
            @RequestParam Integer number, Model model){

        if (mess==""){
            Iterable<Message> messages = messageRepos.findAll();
            Set<Integer> exist = new HashSet<>();
            for (Message mes : messageRepos.findByAuthor(user.getLogin()))
                exist.add(mes.getNumber());
            model.addAttribute("noMessage", "Enter your review");
            model.addAttribute("messages",messages);
            model.addAttribute("exist1", exist.contains(1));
            model.addAttribute("exist2", exist.contains(2));
            model.addAttribute("exist3", exist.contains(3));
            model.addAttribute("exist4", exist.contains(4));
            return "master";
        }

        Message message = new Message(mess,user.getLogin(),number);
        Grade grade = gradeRepos.findByMasterNumber(number);
        if(grade!=null)
            grade.addGrade(gr);
        else
            grade = new Grade(number, gr);


        gradeRepos.save(grade);
        messageRepos.save(message);

        Iterable<Message> messages = messageRepos.findAll();
        model.addAttribute("messages",messages);

        return "redirect:/master";
    }

}
