package com.example.servingwebcontent.service;

import com.example.servingwebcontent.dto.Role;
import com.example.servingwebcontent.dto.User;
import com.example.servingwebcontent.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepos userRepos;
    public List<User> findAll(){
        return userRepos.findAll();
    }
    public void saveChangedUser(User user, Map<String, String> form){
        //Clear all roles target user
        user.getRoles().clear();
        //Go through form roles and add them to user
        for(String key : form.keySet()){
            if (key.equals("ADMIN")){
                user.getRoles().add(Role.valueOf("ADMIN"));
                user.getRoles().add(Role.valueOf("MASTER"));
            }
            if (key.equals("MASTER")){
                user.getRoles().add(Role.valueOf("MASTER"));
            }
            if (key.equals("USER")){
                user.getRoles().add(Role.valueOf("USER"));
            }
        }
        //Save user
        userRepos.save(user);
    }
    public void saveUser(User user) {
        userRepos.save(user);
    }
    public void updateProfile(User user, String nickname, String email) {
        //Check null email after update
        boolean isEmailChanged = (email != null);
        if (isEmailChanged)
            user.setEmail(email);
        user.setNickname(nickname);
        userRepos.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepos.findByLogin(login);
    }
}
