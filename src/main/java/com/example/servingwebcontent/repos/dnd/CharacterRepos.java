package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.domain.dnd.characters.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepos extends JpaRepository<Character, Long> {
    Character findByName(String name);
}
