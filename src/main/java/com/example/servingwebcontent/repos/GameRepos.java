package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.dto.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepos extends JpaRepository<Game, Long> {
    Game findByName(String name);
}
