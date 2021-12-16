package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepos extends CrudRepository<User, Integer> {
    List<User> findByNickname(String nickname);

}