package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepos extends JpaRepository<Race, Long> {
    Race findByName(String name);
}
