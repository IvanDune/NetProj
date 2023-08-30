package com.example.servingwebcontent.service;

import com.example.servingwebcontent.dto.entity.Review;
import com.example.servingwebcontent.dto.entity.Role;
import com.example.servingwebcontent.dto.entity.User;
import com.example.servingwebcontent.exception.EmptyInfoException;
import com.example.servingwebcontent.repos.ReviewRepos;
import com.example.servingwebcontent.repos.UserRepos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MasterService {
    @Autowired
    UserRepos userRepos;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ReviewRepos reviewRepos;

    public ResponseEntity<?> mainPage(User user){
        List masters = new ArrayList<>();
        for (User usr : userRepos.findAll()){
            if(usr.getRoles().contains(Role.MASTER)){
                masters.add(usr);
            }
        }
        Collections.sort(masters);
        return ResponseEntity.ok(masters);
    }

    @Transactional
    public ResponseEntity<?> addMessage(String messageInfo, User user){
        Review review;
        try {
            review  = objectMapper.readValue(messageInfo,Review.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if (review.getMessage()==""){
            throw new EmptyInfoException("Enter your review");
        }
        if(review.getGrade()==0){
            throw new EmptyInfoException("Enter your grade");
        }

        review.setAuthorId(user.getId());
        reviewRepos.save(review);

        Optional<User> usrOptional = userRepos.findById(review.getMasterId());
        User usr = usrOptional.orElse(null);
        usr.changeVote(review);
        userRepos.save(usr);

        return ResponseEntity.ok().build();

    }
}
