package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.dto.GameSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSystemRepos extends JpaRepository<GameSystem, Long> {
    GameSystem findByName(String name);
}
