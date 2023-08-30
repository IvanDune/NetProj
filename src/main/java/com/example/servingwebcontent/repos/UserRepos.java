package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.dto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {
    User findByLogin(String login);

    User findByNickname(String nickname);
}