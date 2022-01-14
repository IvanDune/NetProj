package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepos extends JpaRepository<User, Long> {
    Iterable<User> findByLogin(String login);


}